package gohkenytp.armadilloantics.core.data.server.tags;

import com.teamabnormals.blueprint.core.other.tags.BlueprintBlockTags;
import gohkenytp.armadilloantics.core.registry.ArmadilloAnticsBlocks;
import gohkenytp.armadilloantics.core.ArmadilloAntics;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ArmadilloAnticsBlockTagsProvider extends BlockTagsProvider {
    public ArmadilloAnticsBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ArmadilloAntics.MODID, existingFileHelper);
    }

    @Override
    public void addTags() {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ArmadilloAnticsBlocks.ARMADILLO_BRICKS.get(), ArmadilloAnticsBlocks.ARMADILLO_BRICK_SLAB.get(), ArmadilloAnticsBlocks.ARMADILLO_BRICK_STAIRS.get(), ArmadilloAnticsBlocks.ARMADILLO_BRICK_WALL.get(), ArmadilloAnticsBlocks.ARMADILLO_BRICK_VERTICAL_SLAB.get());
        this.tag(BlockTags.SLABS).add(ArmadilloAnticsBlocks.ARMADILLO_BRICK_SLAB.get());
        this.tag(BlockTags.STAIRS).add(ArmadilloAnticsBlocks.ARMADILLO_BRICK_STAIRS.get());
        this.tag(BlockTags.WALLS).add(ArmadilloAnticsBlocks.ARMADILLO_BRICK_WALL.get());
        this.tag(BlueprintBlockTags.VERTICAL_SLABS).add(ArmadilloAnticsBlocks.ARMADILLO_BRICK_VERTICAL_SLAB.get());
    }
}
