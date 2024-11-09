package net.makepai.hackedclient.hacks;

import net.minecraft.client.MinecraftClient;

public abstract class Hack {
    private boolean isEnabled = false;
    private MinecraftClient client;

    public void toggle() {
        this.isEnabled = !this.isEnabled;
    }

    public void setClient(MinecraftClient client) {
        this.client = client;
    }

    public MinecraftClient getClient() {
        return this.client;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}