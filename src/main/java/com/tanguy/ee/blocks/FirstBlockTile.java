package com.tanguy.ee.blocks;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.rcon.IServer;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.apache.commons.lang3.concurrent.Computable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.plaf.basic.BasicComboBoxUI;

import static com.tanguy.ee.blocks.ModBlocks.FIRSTBLOCK_TILE;

public class FirstBlockTile extends TileEntity implements ITickableTileEntity {

    private LazyOptional<BasicComboBoxUI.ItemHandler> handler = LazyOptional.of(this::createHandler).cast();

    public FirstBlockTile() {
        super(FIRSTBLOCK_TILE);
    }

    // Event called on each minecraft tick
    @Override
    public void tick() {
    }

    @Override
    public void read(CompoundNBT tag) {
        CompoundNBT invTag = tag.getCompound("inv");
        handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>)h).deserializeNBT(invTag));
        super.read(tag);
    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        handler.ifPresent(h -> {
            CompoundNBT compound = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
            tag.put("inv", compound);
        });
        return super.write(tag);
    }

    // Get the ItemStackHandler instance
    private ItemStackHandler createHandler() {
        // Create a new instance
        return new ItemStackHandler(1) {
            // Check if the item given to the block is valid
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return stack.getItem() == Items.DIAMOND;
            }

            // If item is valid, add it in the block inventory
            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot, stack))
                    return stack;
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }
}
