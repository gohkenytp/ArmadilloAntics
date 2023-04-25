package gohkenytp.armadilloantics.client;

import gohkenytp.armadilloantics.core.ArmadilloAntics;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ArmadilloAnticsModelLayers {

    public static final ModelLayerLocation ARMADILLO = register("armadillo");

    public static ModelLayerLocation register(String name) {
        return register(name, "main");
    }

    public static ModelLayerLocation register(String name, String layer) {
        return new ModelLayerLocation(new ResourceLocation(ArmadilloAntics.MODID, name), layer);
    }
}
