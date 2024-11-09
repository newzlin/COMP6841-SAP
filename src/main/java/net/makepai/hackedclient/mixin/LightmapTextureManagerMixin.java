package net.makepai.hackedclient.mixin;

import net.makepai.hackedclient.HackedClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/LightmapTextureManager;getBrightness(Lnet/minecraft/world/dimension/DimensionType;I)F"), method = "update")
    private float getBrightnessMixin(DimensionType type, int lightLevel) {
        if (HackedClient.isEnabled("FullBright")) {
            return 30.0F;
        }
        return LightmapTextureManager.getBrightness(type, lightLevel);
    }
}
