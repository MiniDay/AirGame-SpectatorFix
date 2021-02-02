package net.airgame.fabric.fix.spectator.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class AirGameSpectatorFixClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("观察者模式修复mod初始化完成.");
    }
}
