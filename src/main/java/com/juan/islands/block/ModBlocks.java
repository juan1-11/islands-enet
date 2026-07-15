package com.juan.islands.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block PYRITE_ORE = registerBlock("pyrite_ore",
        new Block(FabricBlockSettings.of(Material.STONE)
            .strength(3.0f, 3.0f)
            .requiresTool()
        )
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier("islands_enet", name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier("islands_enet", name),
            new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }

    public static void registerModBlocks() {
        // Este metodo existe solo para forzar que la clase se cargue
        // y los bloques se registren al iniciar el mod
    }
}