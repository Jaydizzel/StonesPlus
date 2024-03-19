package com.jaydizzle.stonesplus.worldgen;

import com.jaydizzle.stonesplus.StonesMain;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> BLUE_COBBLESTONE_PLACED_KEY = registerKey("blue_cobblestone_placed");
    public static final ResourceKey<PlacedFeature> RED_COBBLESTONE_PLACED_KEY = registerKey("red_cobblestone_placed");
    public static final ResourceKey<PlacedFeature> GREEN_COBBLESTONE_PLACED_KEY = registerKey("green_cobblestone_placed");
    public static final ResourceKey<PlacedFeature> BROWN_COBBLESTONE_PLACED_KEY = registerKey("brown_cobblestone_placed");
    public static final ResourceKey<PlacedFeature> BLACK_COBBLESTONE_PLACED_KEY = registerKey("black_cobblestone_placed");
    public static final ResourceKey<PlacedFeature> TURQUOISE_COBBLESTONE_PLACED_KEY = registerKey("turquoise_cobblestone_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, BLUE_COBBLESTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUE_COBBLESTONE_KEY),
                ModOrePlacement.commonOrePlacement(20,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(120))));

        register(context, RED_COBBLESTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_COBBLESTONE_KEY),
                ModOrePlacement.commonOrePlacement(20,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(120))));

        register(context, GREEN_COBBLESTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GREEN_COBBLESTONE_KEY),
                ModOrePlacement.commonOrePlacement(20,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(120))));

        register(context, BROWN_COBBLESTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BROWN_COBBLESTONE_KEY),
                ModOrePlacement.commonOrePlacement(20,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(120))));

        register(context, BLACK_COBBLESTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLACK_COBBLESTONE_KEY),
                ModOrePlacement.commonOrePlacement(20,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(120))));

        register(context, TURQUOISE_COBBLESTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TURQUOISE_COBBLESTONE_KEY),
                ModOrePlacement.commonOrePlacement(20,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(120))));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(StonesMain.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
