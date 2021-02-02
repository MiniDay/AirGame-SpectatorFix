package net.airgame.fabric.fix.spectator.mixin;

import net.airgame.fabric.fix.spectator.manager.SpectatorManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin {
    private static int ticks = 0;

    @SuppressWarnings("ConstantConditions")
    @Inject(at = @At("RETURN"), method = "tick(Ljava/util/function/BooleanSupplier;)V")
    public void tick(CallbackInfo info) {
        if (++ticks % 20 != 0) {
            return;
        }
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity clientPlayerEntity = client.player;
        PlayerEntity player = clientPlayerEntity.clientWorld.getPlayerByUuid(clientPlayerEntity.getUuid());
        if (!player.isSpectator()) {
            return;
        }
        if (SpectatorManager.getSpectatorTargetID() <= 0) {
            return;
        }
        if (client.cameraEntity != clientPlayerEntity) {
            return;
        }
        client.setCameraEntity(client.world.getEntityById(SpectatorManager.getSpectatorTargetID()));
    }

}
