package gohkenytp.armadilloantics.core.data.server.modifiers;

import com.mojang.serialization.JsonOps;
import gohkenytp.armadilloantics.core.ArmadilloAntics;
import gohkenytp.armadilloantics.core.other.tags.ArmadilloAnticsBiomeTags;
import gohkenytp.armadilloantics.core.registry.ArmadilloAnticsEntityTypes;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddSpawnsBiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.List;

public class ArmadilloAnticsBiomeModifierProvider {
	private static final RegistryAccess ACCESS = RegistryAccess.builtinCopy();
	private static final Registry<Biome> BIOMES = ACCESS.registryOrThrow(Registry.BIOME_REGISTRY);
	private static final HashMap<ResourceLocation, BiomeModifier> MODIFIERS = new HashMap<>();

	public static JsonCodecProvider<BiomeModifier> create(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		addSpawn("armadillo", ArmadilloAnticsBiomeTags.HAS_ARMADILLO, new MobSpawnSettings.SpawnerData(ArmadilloAnticsEntityTypes.ARMADILLO.get(), 3, 1, 3));
		return JsonCodecProvider.forDatapackRegistry(generator, existingFileHelper, ArmadilloAntics.MODID, RegistryOps.create(JsonOps.INSTANCE, ACCESS), ForgeRegistries.Keys.BIOME_MODIFIERS, MODIFIERS);
	}

	private static void addSpawn(String name, TagKey<Biome> tagKey, MobSpawnSettings.SpawnerData... spawns) {
		addModifier("add_spawn/" + name, new AddSpawnsBiomeModifier(new HolderSet.Named<>(BIOMES, tagKey), List.of(spawns)));
	}

	private static void addModifier(String name, BiomeModifier modifier) {
		MODIFIERS.put(new ResourceLocation(ArmadilloAntics.MODID, name), modifier);
	}
}