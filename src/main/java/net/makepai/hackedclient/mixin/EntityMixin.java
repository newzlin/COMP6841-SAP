package net.makepai.hackedclient.mixin;

import net.makepai.hackedclient.HackedClient;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(at = @At("HEAD"), method = "getStepHeight", cancellable = true)
    void getStepHeightMixin(CallbackInfoReturnable<Float> info) {
        if (HackedClient.isEnabled("Step")) {
            info.setReturnValue(10.0F);
            info.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "getY", cancellable = true)
    void getYMixin(CallbackInfoReturnable<Double> info) {
        if (HackedClient.isEnabled("Fly")) {
            info.setReturnValue(0D);
            info.cancel();
        }
    }
}
