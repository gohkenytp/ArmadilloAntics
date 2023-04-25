package gohkenytp.armadilloantics.client.renderer.entity;

import gohkenytp.armadilloantics.client.ArmadilloAnticsModelLayers;
import gohkenytp.armadilloantics.client.model.ArmadilloModel;
import gohkenytp.armadilloantics.common.entity.Armadillo;
import gohkenytp.armadilloantics.core.ArmadilloAntics;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArmadilloRenderer extends MobRenderer<Armadillo, ArmadilloModel<Armadillo>> {
	private static final ResourceLocation ARMADILLO_LOCATION = new ResourceLocation(ArmadilloAntics.MODID, "textures/entity/armadillo/armadillo.png");

	public ArmadilloRenderer(EntityRendererProvider.Context context) {
		super(context, new ArmadilloModel<>(context.bakeLayer(ArmadilloAnticsModelLayers.ARMADILLO)), 0.7F);
	}

	public ResourceLocation getTextureLocation(Armadillo armadillo) {
		return ARMADILLO_LOCATION;
	}
}