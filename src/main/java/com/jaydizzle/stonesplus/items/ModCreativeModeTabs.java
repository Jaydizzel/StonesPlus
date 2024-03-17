package com.jaydizzle.stonesplus.items;

import com.jaydizzle.stonesplus.StonesMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StonesMain.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register("main_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.main_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ItemInit.SAPPHIRE.get());
                        pOutput.accept(ItemInit.RAW_SAPPHIRE.get());

                        pOutput.accept(Items.DIAMOND);


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
