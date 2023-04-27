package gohkenytp.armadilloantics.core.registry;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import gohkenytp.armadilloantics.core.ArmadilloAntics;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod.EventBusSubscriber(modid = ArmadilloAntics.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmadilloAnticsBiomeModifierTypes {
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, ArmadilloAntics.MODID);

    public static final RegistryObject<Codec<InvertedRemoveSpawnsBiomeModifier>> REMOVE_SPAWNS_INVERTED = BIOME_MODIFIER_SERIALIZERS.register("remove_spawns_inverted", () ->
            RecordCodecBuilder.create(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("inverted_biomes").forGetter(InvertedRemoveSpawnsBiomeModifier::biomes),
                    RegistryCodecs.homogeneousList(ForgeRegistries.Keys.ENTITY_TYPES).fieldOf("entity_types").forGetter(InvertedRemoveSpawnsBiomeModifier::entityTypes)
            ).apply(builder, InvertedRemoveSpawnsBiomeModifier::new))
    );

    public record InvertedRemoveSpawnsBiomeModifier(HolderSet<Biome> biomes, HolderSet<EntityType<?>> entityTypes) implements BiomeModifier {
        @Override
        public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
            if (phase == Phase.REMOVE && !this.biomes.contains(biome)) {
                MobSpawnSettingsBuilder spawnBuilder = builder.getMobSpawnSettings();
                for (MobCategory category : MobCategory.values()) {
                    List<MobSpawnSettings.SpawnerData> spawns = spawnBuilder.getSpawner(category);
                    spawns.removeIf(spawnerData -> this.entityTypes.contains(ForgeRegistries.ENTITY_TYPES.getHolder(spawnerData.type).get()));
                }
            }
        }

        @Override
        public Codec<? extends BiomeModifier> codec() {
            return REMOVE_SPAWNS_INVERTED.get();
        }
    }
}