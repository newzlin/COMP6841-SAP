package net.makepai.hackedclient.mixin;

import net.makepai.hackedclient.HackedClient;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(at = @At("HEAD"), method = "getMovementSpeed", cancellable = true)
    void getMovementSpeedMixin(CallbackInfoReturnable<Float> info) {
        if (HackedClient.isEnabled("Bhop")) {
            info.setReturnValue(1.0F);
            info.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "computeFallDamage", cancellable = true)
    void computeFallDamageMixin(float fallDistance, float damageMultiplier, CallbackInfoReturnable<Integer> info) {
        if (HackedClient.isEnabled("NoFallDamage")) {
            info.setReturnValue(0);
            info.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "getJumpBoostVelocityModifier", cancellable = true)
    void getJumpBoostVelocityModifier(CallbackInfoReturnable<Float> info) {
        if (HackedClient.isEnabled("JumpBoost")) {
            info.setReturnValue(2.0F);
            info.cancel();
        }
    }

}
