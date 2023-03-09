package com.github.x3rmination;

import com.github.x3rmination.registry.FeatureRegistry;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("basic_lobby")
public class BasicLobby {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "basic_lobby";

    public BasicLobby() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BasicLobbyConfig.SPEC, "basic_lobby-common.toml");
        FeatureRegistry.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
