package com.jaydizzle.stonesplus;

import com.jaydizzle.stonesplus.block.BlockInit;
import com.jaydizzle.stonesplus.items.ItemInit;
import com.jaydizzle.stonesplus.items.ModCreativeModeTabs;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(StonesMain.MOD_ID)
public class StonesMain {
    public static final String MOD_ID = "stones_plus";
    private static final Logger LOGGER = LogUtils.getLogger();
    public StonesMain()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        BlockInit.register(modEventBus);
        ItemInit.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemInit.RAW_SAPPHIRE);
            event.accept(ItemInit.SAPPHIRE);
        }
    }
        @SubscribeEvent
        public void onServerStarting(ServerStartingEvent event) {

    }

        @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
        public static class ClientModEvents {
            @SubscribeEvent
            public static void onClientSetup(FMLClientSetupEvent event) {

            }
        }
    }