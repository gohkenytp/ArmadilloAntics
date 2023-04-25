package gohkenytp.armadilloantics.core;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import gohkenytp.armadilloantics.client.ArmadilloAnticsModelLayers;
import gohkenytp.armadilloantics.client.model.ArmadilloModel;
import gohkenytp.armadilloantics.client.renderer.entity.ArmadilloRenderer;
import gohkenytp.armadilloantics.common.entity.Armadillo;
import gohkenytp.armadilloantics.core.data.server.modifiers.ArmadilloAnticsBiomeModifierProvider;
import gohkenytp.armadilloantics.core.data.server.tags.ArmadilloAnticsBiomeTagsProvider;
import gohkenytp.armadilloantics.core.data.server.tags.ArmadilloAnticsBlockTagsProvider;
import gohkenytp.armadilloantics.core.data.server.tags.ArmadilloAnticsItemTagsProvider;
import gohkenytp.armadilloantics.core.registry.ArmadilloAnticsEntityTypes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ArmadilloAntics.MODID)
public class ArmadilloAntics {
    public static final String MODID = "armadilloantics";

    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);


    public ArmadilloAntics() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        REGISTRY_HELPER.register(bus);

        bus.addListener(this::commonSetup);
        bus.addListener(this::dataSetup);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            bus.addListener(this::registerLayerDefinitions);
            bus.addListener(this::registerRenderers);
        });

    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(ArmadilloAnticsEntityTypes::registerEntitySpawns);
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        boolean includeServer = event.includeServer();
        ArmadilloAnticsBlockTagsProvider blockTags = new ArmadilloAnticsBlockTagsProvider(generator, existingFileHelper);
        generator.addProvider(includeServer, blockTags);
        generator.addProvider(includeServer, new ArmadilloAnticsItemTagsProvider(generator, blockTags, existingFileHelper));
        generator.addProvider(includeServer, new ArmadilloAnticsBiomeTagsProvider(generator, existingFileHelper));
        generator.addProvider(includeServer, ArmadilloAnticsBiomeModifierProvider.create(generator, existingFileHelper));
    }

    @OnlyIn(Dist.CLIENT)
    private void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ArmadilloAnticsModelLayers.ARMADILLO, ArmadilloModel::createBodyLayer);
    }

    @OnlyIn(Dist.CLIENT)
    private void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ArmadilloAnticsEntityTypes.ARMADILLO.get(), ArmadilloRenderer::new);
    }
}
