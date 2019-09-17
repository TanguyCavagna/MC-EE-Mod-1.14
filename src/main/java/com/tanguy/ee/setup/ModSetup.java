package com.tanguy.ee.setup;

import com.tanguy.ee.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

    // Inventory tab
    public ItemGroup itemGroup = new ItemGroup("ee") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.FIRSTBLOCK);
        }
    };

    public void init() {

    }
}
