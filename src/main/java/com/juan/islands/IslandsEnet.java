package com.juan.islands;

import com.juan.islands.block.ModBlocks;
import com.juan.islands.item.ModItems;
import com.juan.islands.entity.ModEntities;
import com.juan.islands.entity.custom.SharkEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IslandsEnet implements ModInitializer {

	public static final String MOD_ID = "islands_enet";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModBlocks.registerModBlocks();
        ModItems.registerModItems();
		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.SHARK, SharkEntity.createSharkAttributes());

	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
