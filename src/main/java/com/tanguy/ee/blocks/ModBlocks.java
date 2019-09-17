package com.tanguy.ee.blocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {
    @ObjectHolder("ee:firstblock")
    public static FirstBlock FIRSTBLOCK;

    // For each tile entity, create a new TileEntityType
    @ObjectHolder("ee:firstblock")
    public static TileEntityType<FirstBlockTile> FIRSTBLOCK_TILE;
}
