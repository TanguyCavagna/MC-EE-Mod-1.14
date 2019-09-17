package com.tanguy.ee.items;

import com.tanguy.ee.EE;
import net.minecraft.item.Item;

public class FirstItem extends Item {
    public FirstItem() {
        super(
            new Item.Properties()
            .maxStackSize(1)
            .group(EE.setup.itemGroup)
        );

        setRegistryName("firstitem");
    }
}
