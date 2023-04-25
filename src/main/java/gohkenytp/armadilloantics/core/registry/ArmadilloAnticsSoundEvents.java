package gohkenytp.armadilloantics.core.registry;

import com.teamabnormals.blueprint.core.util.registry.SoundSubRegistryHelper;
import gohkenytp.armadilloantics.core.ArmadilloAntics;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ArmadilloAntics.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmadilloAnticsSoundEvents {
    public static final SoundSubRegistryHelper HELPER = ArmadilloAntics.REGISTRY_HELPER.getSoundSubHelper();

    public static final RegistryObject<SoundEvent> ARMADILLO_HURT = HELPER.createSoundEvent("entity.armadillo.hurt");

}
