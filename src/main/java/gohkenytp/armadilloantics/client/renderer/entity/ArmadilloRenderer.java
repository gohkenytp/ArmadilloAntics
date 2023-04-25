package gohkenytp.armadilloantics.client.renderer.entity;

import gohkenytp.armadilloantics.client.model.ArmadilloModel;
import gohkenytp.armadilloantics.common.entity.Armadillo;
import gohkenytp.armadilloantics.core.ArmadilloAntics;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArmadilloRenderer extends MobRenderer<Armadillo, ArmadilloModel<Armadillo>> {
	public static final ResourceLocation ARMADILLO_LOCATION = new ResourceLocation(ArmadilloAntics.MODID, "textures/entity/armadillo.png");
	public static final ModelLayerLocation MODEL_LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ArmadilloAntics.MODID, "armadillo"), "main");

	public ArmadilloRenderer(EntityRendererProvider.Context context) {
		super(context, new ArmadilloModel<>(context.bakeLayer(MODEL_LAYER_LOCATION)), 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(Armadillo armadillo) {
		return ARMADILLO_LOCATION;
	}
}
