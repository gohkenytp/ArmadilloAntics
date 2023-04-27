package gohkenytp.armadilloantics.core.data.server.tags;

import com.teamabnormals.blueprint.core.other.tags.BlueprintBlockTags;
import com.teamabnormals.blueprint.core.other.tags.BlueprintItemTags;
import gohkenytp.armadilloantics.core.ArmadilloAntics;
import gohkenytp.armadilloantics.core.other.tags.ArmadilloAnticsItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ArmadilloAnticsItemTagsProvider extends ItemTagsProvider {
	public ArmadilloAnticsItemTagsProvider(DataGenerator generator, ArmadilloAnticsBlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
		super(generator, blockTags, ArmadilloAntics.MODID, existingFileHelper);
	}

	@Override
	public void addTags() {
		this.copy(BlockTags.SLABS, ItemTags.SLABS);
		this.copy(BlockTags.STAIRS, ItemTags.STAIRS);
		this.copy(BlockTags.WALLS, ItemTags.WALLS);
		this.copy(BlueprintBlockTags.VERTICAL_SLABS, BlueprintItemTags.VERTICAL_SLABS);

		this.tag(ArmadilloAnticsItemTags.ARMADILLO_FOOD).add(Items.SPIDER_EYE, Items.FERMENTED_SPIDER_EYE);
	}
}