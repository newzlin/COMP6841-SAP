package net.makepai.hackedclient.mixin;

import net.makepai.hackedclient.gui.HackMenuScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {

    protected GameMenuScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "initWidgets")
    void initWidgetsMixin(CallbackInfo info) {
        ButtonWidget buttonWidget = ButtonWidget.builder(Text.of("Hack Menu"), button -> {
            MinecraftClient.getInstance().setScreen(new HackMenuScreen(this));
        }).width(150).position(10,10).build();

        this.addDrawableChild(buttonWidget);
    }
}
