package com.github.x3rmination.feature;

import com.github.x3rmination.BasicLobby;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class LobbyFeature extends Feature<NoneFeatureConfiguration> implements FeatureConfiguration {

    public LobbyFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldgenlevel = context.level();
        StructureManager structuremanager = worldgenlevel.getLevel().getServer().getStructureManager();
        StructureTemplate structuretemplate = structuremanager.getOrCreate(new ResourceLocation(BasicLobby.MOD_ID, "lobby"));
        int x = context.origin().getX() - (structuretemplate.getSize().getX() / 2);
        int z = context.origin().getZ() - (structuretemplate.getSize().getZ() / 2);
        int y = context.origin().getY();
        BlockPos placePos = new BlockPos(x, y, z);
        structuretemplate.placeInWorld(worldgenlevel, placePos, placePos, new StructurePlaceSettings(), context.random(), 4);
        return true;
    }
}
