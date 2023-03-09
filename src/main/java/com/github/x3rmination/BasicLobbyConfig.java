package com.github.x3rmination;

import net.minecraftforge.common.ForgeConfigSpec;

public class BasicLobbyConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue suppress_warnings;


    static {
        BUILDER.push("Basic Lobby config");
        suppress_warnings = BUILDER.comment("Suppress spawn radius warnings").define("suppress_warnings", false);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
