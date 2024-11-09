package net.makepai.hackedclient.gui;

import net.makepai.hackedclient.HackedClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.ChatOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.GridWidget;
import net.minecraft.client.gui.widget.SimplePositioningWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class HackMenuScreen extends Screen {
    private final Screen parent;

    public HackMenuScreen(Screen parent) {
        super(Text.translatable("hacks.menu"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        GridWidget gridWidget = new GridWidget();
        gridWidget.getMainPositioner().marginX(5).marginBottom(4).alignHorizontalCenter();
        GridWidget.Adder adder = gridWidget.createAdder(2);

        adder.add(ButtonWidget.builder(Text.of("Speed"), button -> HackedClient.toggle("Speed")).build());
        adder.add(ButtonWidget.builder(Text.of("Bhop"), button -> HackedClient.toggle("Bhop")).build());
        adder.add(ButtonWidget.builder(Text.of("Jump Boost"), button -> HackedClient.toggle("JumpBoost")).build());
        adder.add(ButtonWidget.builder(Text.of("Step"), button -> HackedClient.toggle("Step")).build());
        adder.add(ButtonWidget.builder(Text.of("Full Bright"), button -> HackedClient.toggle("FullBright")).build());
        adder.add(ButtonWidget.builder(Text.of("No Fall Damage (SP)"), button -> HackedClient.toggle("NoFallDamage")).build());

        adder.add(ButtonWidget.builder(ScreenTexts.DONE, button -> this.client.setScreen(this.parent)).width(200).build(), 2, adder.copyPositioner().marginTop(6));
        gridWidget.refreshPositions();
        SimplePositioningWidget.setPos(gridWidget, 0, this.height / 6 - 12, this.width, this.height, 0.5F, 0.0F);
        gridWidget.forEachChild(this::addDrawableChild);
    }
}
