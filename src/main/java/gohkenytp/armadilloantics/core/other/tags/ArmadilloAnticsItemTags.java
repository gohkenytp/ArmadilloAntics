package gohkenytp.armadilloantics.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import gohkenytp.armadilloantics.core.ArmadilloAntics;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ArmadilloAnticsItemTags {
	public static final TagKey<Item> ARMADILLO_FOOD = itemTag("armadillo_food");

	private static TagKey<Item> itemTag(String name) {
		return TagUtil.itemTag(ArmadilloAntics.MODID, name);
	}
}
