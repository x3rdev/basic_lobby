package com.github.x3rmination.registry;

import com.github.x3rmination.feature.LobbyFeature;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ConfiguredFeatureRegistry {

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LOBBY_FEATURE = FeatureUtils.register(
            "lobby",
            FeatureRegistry.LOBBY_FEATURE.get(),
            FeatureConfiguration.NONE);
}
