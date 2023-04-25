package gohkenytp.armadilloantics.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import gohkenytp.armadilloantics.core.ArmadilloAntics;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ArmadilloAnticsBiomeTags {
	public static final TagKey<Biome> HAS_ARMADILLO = biomeTag("has_animal/armadillo");

	private static TagKey<Biome> biomeTag(String name) {
		return TagUtil.biomeTag(ArmadilloAntics.MODID, name);
	}
}
