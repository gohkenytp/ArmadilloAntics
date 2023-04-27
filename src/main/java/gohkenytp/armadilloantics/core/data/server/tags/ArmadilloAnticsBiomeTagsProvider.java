package gohkenytp.armadilloantics.core.data.server.tags;

import gohkenytp.armadilloantics.core.ArmadilloAntics;
import gohkenytp.armadilloantics.core.other.tags.ArmadilloAnticsBiomeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ArmadilloAnticsBiomeTagsProvider extends BiomeTagsProvider {
	public ArmadilloAnticsBiomeTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, ArmadilloAntics.MODID, existingFileHelper);
	}

	@Override
	public void addTags() {
		this.tag(ArmadilloAnticsBiomeTags.HAS_ARMADILLO).add(Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE, Biomes.SPARSE_JUNGLE);
	}
}