package com.jaydizzle.stonesplus.item;

import com.jaydizzle.stonesplus.StonesMain;
import com.jaydizzle.stonesplus.block.BlockInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StonesMain.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register("main_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlockInit.BLUE_COBBLESTONE.get()))
                    .title(Component.translatable("creativetab.main_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(BlockInit.BLUE_COBBLESTONE.get());
                        pOutput.accept(BlockInit.BROWN_COBBLESTONE.get());
                        pOutput.accept(BlockInit.BLACK_COBBLESTONE.get());
                        pOutput.accept(BlockInit.GREEN_COBBLESTONE.get());
                        pOutput.accept(BlockInit.RED_COBBLESTONE.get());
                        pOutput.accept(BlockInit.SPIRAL_STONE.get());
                        pOutput.accept(BlockInit.TURQUOISE_COBBLESTONE.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
