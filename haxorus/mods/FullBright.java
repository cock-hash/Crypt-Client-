package haxorus.mods;

import org.lwjgl.input.Keyboard;

import haxorus.main.Category;

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
