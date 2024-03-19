package com.jaydizzle.stonesplus.block;

import com.jaydizzle.stonesplus.StonesMain;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, StonesMain.MOD_ID);

    public static final RegistryObject<Block> SPIRAL_STONE = registerBlock("spiral_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> BLACK_COBBLESTONE = registerBlock("black_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> BROWN_COBBLESTONE = registerBlock("brown_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> GREEN_COBBLESTONE = registerBlock("green_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> BLUE_COBBLESTONE = registerBlock("blue_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> TURQUOISE_COBBLESTONE = registerBlock("turquoise_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> RED_COBBLESTONE = registerBlock("red_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return com.jaydizzle.stonesplus.item.ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
