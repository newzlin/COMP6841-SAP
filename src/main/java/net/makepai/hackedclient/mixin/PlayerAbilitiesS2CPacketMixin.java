package net.makepai.hackedclient.mixin;

import net.makepai.hackedclient.HackedClient;
import net.minecraft.network.packet.s2c.play.PlayerAbilitiesS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerAbilitiesS2CPacket.class)
public class PlayerAbilitiesS2CPacketMixin {

    @Inject(at = @At("HEAD"), method = "allowFlying", cancellable = true)
    void allowFlyingMixin(CallbackInfoReturnable<Boolean> info) {
        //if (HackedClient.isEnabled("Fly")) {
            info.setReturnValue(true);
            info.cancel();
       // }
    }
}
