package com.github.x3rmination.mixin;

import com.github.x3rmination.BasicLobby;
import com.github.x3rmination.BasicLobbyConfig;
import com.github.x3rmination.feature.LobbyFeature;
import com.github.x3rmination.registry.FeatureRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.storage.ServerLevelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {

    @Inject(method = "setInitialSpawn", at = @At("TAIL"))
    private static void setInitialSpawn(ServerLevel serverLevel, ServerLevelData serverLevelData, boolean p_177899_, boolean p_177900_, CallbackInfo ci) {
        ChunkGenerator chunkgenerator = serverLevel.getChunkSource().getGenerator();
        LobbyFeature feature = FeatureRegistry.LOBBY_FEATURE.get();
        BlockPos spawnPos = new BlockPos(serverLevelData.getXSpawn(), serverLevelData.getYSpawn(), serverLevelData.getZSpawn());
        feature.place(FeatureConfiguration.NONE, serverLevel, chunkgenerator, serverLevel.random, spawnPos);
        if(Boolean.TRUE.equals(!BasicLobbyConfig.suppress_warnings.get()) && serverLevel.getServer().getSpawnRadius(serverLevel) != 0) {
            BasicLobby.LOGGER.warn("Spawn radius is not 0, you may not spawn in the intended location (you can suppress this warning in the config");
        }
    }
}
