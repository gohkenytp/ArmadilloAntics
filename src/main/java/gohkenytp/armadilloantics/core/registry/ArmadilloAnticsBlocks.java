package gohkenytp.armadilloantics.core.registry;

import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import gohkenytp.armadilloantics.core.ArmadilloAntics;
import gohkenytp.armadilloantics.core.other.ArmadilloAnticsConstants;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ArmadilloAntics.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmadilloAnticsBlocks {
    public static final BlockSubRegistryHelper HELPER = ArmadilloAntics.REGISTRY_HELPER.getBlockSubHelper();
    public static final RegistryObject<Block> ARMADILLO_BRICKS = HELPER.createBlock("armadillo_bricks", () -> new Block(ArmadilloAnticsBlockProperties.ARMADILLO_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ARMADILLO_BRICK_STAIRS = HELPER.createBlock("armadillo_brick_stairs", () -> new StairBlock(ARMADILLO_BRICKS.get()::defaultBlockState, ArmadilloAnticsBlockProperties.ARMADILLO_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ARMADILLO_BRICK_SLAB = HELPER.createBlock("armadillo_brick_slab", () -> new SlabBlock(ArmadilloAnticsBlockProperties.ARMADILLO_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ARMADILLO_BRICK_WALL = HELPER.createBlock("armadillo_brick_wall", () -> new WallBlock(ArmadilloAnticsBlockProperties.ARMADILLO_BRICKS), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> ARMADILLO_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock(ArmadilloAnticsConstants.QUARK, "armadillo_brick_vertical_slab", () -> new VerticalSlabBlock(ArmadilloAnticsBlockProperties.ARMADILLO_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static class ArmadilloAnticsBlockProperties {
        public static final BlockBehaviour.Properties ARMADILLO_BRICKS = Block.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(6.0F, 6.0F).sound(SoundType.COPPER);
    }
}
