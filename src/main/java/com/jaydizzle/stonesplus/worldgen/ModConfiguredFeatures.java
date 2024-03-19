package com.jaydizzle.stonesplus.worldgen;

import com.jaydizzle.stonesplus.StonesMain;
import com.jaydizzle.stonesplus.block.BlockInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_COBBLESTONE_KEY = registerKey("blue_cobblestone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_COBBLESTONE_KEY = registerKey("green_cobblestone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACK_COBBLESTONE_KEY = registerKey("black_cobblestone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_COBBLESTONE_KEY = registerKey("red_cobblestone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_COBBLESTONE_KEY = registerKey("brown_cobblestone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TURQUOISE_COBBLESTONE_KEY = registerKey("turquoise_cobblestone");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new BlockMatchTest(Blocks.STONE);

        List<OreConfiguration.TargetBlockState> overworldBlueCobblestone = List.of
                (OreConfiguration.target(stoneReplaceable, BlockInit.BLUE_COBBLESTONE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldBlackCobblestone = List.of
                (OreConfiguration.target(stoneReplaceable, BlockInit.BLACK_COBBLESTONE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldBrownCobblestone = List.of
                (OreConfiguration.target(stoneReplaceable, BlockInit.BROWN_COBBLESTONE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldGreenCobblestone = List.of
                (OreConfiguration.target(stoneReplaceable, BlockInit.GREEN_COBBLESTONE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldRedCobblestone = List.of
                (OreConfiguration.target(stoneReplaceable, BlockInit.RED_COBBLESTONE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldTurquoiseCobblestone = List.of
                (OreConfiguration.target(stoneReplaceable, BlockInit.TURQUOISE_COBBLESTONE.get().defaultBlockState()));

        register(context, BLUE_COBBLESTONE_KEY, Feature.ORE, new OreConfiguration(overworldBlueCobblestone, 128));
        register(context, BROWN_COBBLESTONE_KEY, Feature.ORE, new OreConfiguration(overworldBrownCobblestone, 128));
        register(context, BLACK_COBBLESTONE_KEY, Feature.ORE, new OreConfiguration(overworldBlackCobblestone, 128));
        register(context, RED_COBBLESTONE_KEY, Feature.ORE, new OreConfiguration(overworldRedCobblestone, 128));
        register(context, GREEN_COBBLESTONE_KEY, Feature.ORE, new OreConfiguration(overworldGreenCobblestone, 128));
        register(context, TURQUOISE_COBBLESTONE_KEY, Feature.ORE, new OreConfiguration(overworldTurquoiseCobblestone, 128));

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(StonesMain.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}