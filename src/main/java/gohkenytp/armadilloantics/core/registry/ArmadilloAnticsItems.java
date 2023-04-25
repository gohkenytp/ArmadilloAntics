package gohkenytp.armadilloantics.core.registry;

import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import gohkenytp.armadilloantics.core.ArmadilloAntics;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmadilloAnticsItems {
    public static final ItemSubRegistryHelper HELPER = ArmadilloAntics.REGISTRY_HELPER.getItemSubHelper();
    public static final RegistryObject<ForgeSpawnEggItem> ARMADILLO_SPAWN_EGG = HELPER.createSpawnEggItem("armadillo", ArmadilloAnticsEntityTypes.ARMADILLO::get, 0xB5AEAC, 0xBCA593);
    public static final RegistryObject<Item> ARMADILLO_SHELL = HELPER.createItem("armadillo_shell", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

}
