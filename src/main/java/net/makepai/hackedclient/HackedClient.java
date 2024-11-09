package net.makepai.hackedclient;

import net.fabricmc.api.ModInitializer;

import net.makepai.hackedclient.hacks.*;
import net.makepai.hackedclient.hacks.Bhop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class HackedClient implements ModInitializer {
	public static final String MOD_ID = "hacked-client";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	private static final List<Hack> Hacks = new ArrayList<>();

	@Override
	public void onInitialize() {
		Hacks.add(new Speed());
		Hacks.add(new Bhop());
		Hacks.add(new JumpBoost());
		Hacks.add(new Step());
		Hacks.add(new NoFallDamage());
		Hacks.add(new FullBright());
		Hacks.add(new Fly());
	}

	public static boolean isEnabled(String hack) {
		for (Hack currHack : Hacks) {
			if (currHack.getClass().getSimpleName().equals(hack)) {
				return currHack.isEnabled();
			}
		}
		return false;
	}

	public static void toggle(String hack) {
		for (Hack currHack : Hacks) {
			if (currHack.getClass().getSimpleName().equals(hack)) {
				currHack.toggle();
			}
		}
	}
}
