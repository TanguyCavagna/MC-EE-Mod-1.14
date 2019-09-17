package com.tanguy.ee.setup;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ServerProxy implements IProxy {
    @Override
    public void init() {

    }

    @Override
    public World getClientWorld() {
        throw new IllegalStateException("Run this only on client side !");
    }

    @Override
    public PlayerEntity getClienPlayer() {
        throw new IllegalStateException("Run this only on client side !");
    }
}
