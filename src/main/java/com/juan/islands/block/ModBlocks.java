package com.juan.islands.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import com.juan.islands.block.custom.SeaTorchBlock;

public class ModBlocks {

    public static final Block PYRITE_ORE = registerBlock("pyrite_ore",
        new Block(FabricBlockSettings.of(Material.STONE)
            .strength(3.0f, 3.0f)
            .requiresTool()
        ),
        ItemGroup.BUILDING_BLOCKS
    );

    public static final Block SEA_TORCH = registerBlock("sea_torch",
        new SeaTorchBlock(FabricBlockSettings.of(Material.DECORATION)
            .noCollision()
            .luminance(state -> 14)
            .sounds(BlockSoundGroup.WOOD)
            .breakInstantly()
        ),
        ItemGroup.DECORATIONS
    );

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier("islands_enet", name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier("islands_enet", name),
            new BlockItem(block, new Item.Settings().group(group)));
    }

    public static void registerModBlocks() {}
}