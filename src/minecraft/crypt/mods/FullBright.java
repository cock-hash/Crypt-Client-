package crypt.mods;

import org.lwjgl.input.Keyboard;

import crypt.main.Category;

public class FullBright extends Mod {

	public FullBright() {
		super("FullBright", "Fullbright", Keyboard.KEY_L, Category.RENDER);
	}
	public void onUpdate() {
		if (this.isToggled()) {
			mc.gameSettings.gammaSetting = 100F;
		}
	}
	public void onDisable() {
			mc.gameSettings.gammaSetting = 1F;
	}

}
