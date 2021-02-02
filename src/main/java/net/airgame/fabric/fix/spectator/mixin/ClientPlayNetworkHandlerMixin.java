package net.airgame.fabric.fix.spectator.mixin;

import net.airgame.fabric.fix.spectator.manager.SpectatorManager;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.SetCameraEntityS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin {

    @ModifyVariable(at = @At("RETURN"), ordinal = 0, method = "onSetCameraEntity(Lnet/minecraft/network/packet/s2c/play/SetCameraEntityS2CPacket;)V")
    public SetCameraEntityS2CPacket onSetCameraEntity(SetCameraEntityS2CPacket packet) {
        SpectatorManager.setSpectatorTargetID(packet.entityId);
        System.out.println(packet.entityId);
        return packet;
    }

}
