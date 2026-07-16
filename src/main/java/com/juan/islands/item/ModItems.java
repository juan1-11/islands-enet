package com.juan.islands.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item RAW_PYRITE = registerItem("raw_pyrite",
        new Item(new Item.Settings().group(ItemGroup.MISC)));

    public static final Item SEA_TORCH = registerItem("sea_torch",
        new Item(new Item.Settings().group(ItemGroup.DECORATIONS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier("islands_enet", name), item);
    }

        
    public static void registerModItems() {
        // Fuerza la carga de la clase
    }
}