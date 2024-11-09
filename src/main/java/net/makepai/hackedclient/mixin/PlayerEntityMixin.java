package net.makepai.hackedclient.mixin;

import net.makepai.hackedclient.HackedClient;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Inject(at = @At("HEAD"), method = "getMovementSpeed", cancellable = true)
    void getMovementSpeedMixin(CallbackInfoReturnable<Float> info) {
        if (HackedClient.isEnabled("Speed")) {
            info.setReturnValue(2.0F);
            info.cancel();
        }
    }
}
