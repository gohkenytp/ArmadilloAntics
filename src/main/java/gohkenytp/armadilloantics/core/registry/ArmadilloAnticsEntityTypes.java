package gohkenytp.armadilloantics.core.registry;

import com.teamabnormals.blueprint.core.util.registry.EntitySubRegistryHelper;
import gohkenytp.armadilloantics.common.entity.Armadillo;
import gohkenytp.armadilloantics.core.ArmadilloAntics;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ArmadilloAntics.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmadilloAnticsEntityTypes {
    public static final EntitySubRegistryHelper HELPER = ArmadilloAntics.REGISTRY_HELPER.getEntitySubHelper();
    public static final RegistryObject<EntityType<Armadillo>> ARMADILLO = HELPER.createLivingEntity("armadillo", Armadillo::new, MobCategory.CREATURE, 0.5F, 0.5F);
    public static void registerEntitySpawns() {
        SpawnPlacements.register(ARMADILLO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ARMADILLO.get(), Armadillo.createAttributes().build());
    }
}
