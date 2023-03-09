package com.github.x3rmination.registry;

import com.github.x3rmination.BasicLobby;
import com.github.x3rmination.feature.LobbyFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FeatureRegistry {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, BasicLobby.MOD_ID);

    public static final RegistryObject<LobbyFeature> LOBBY_FEATURE = FEATURES.register("lobby",
            () -> new LobbyFeature(NoneFeatureConfiguration.CODEC));
}
