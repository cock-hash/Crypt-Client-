package crypt.mods;

import org.lwjgl.input.Keyboard;

import crypt.main.Category;

public class Flight extends Mod {

	public Flight() {
		super("LFlight", "LFlight", Keyboard.KEY_F, Category.MOVEMENT);
	}
	public void onUpdate() {
		if (this.isToggled()) {
			mc.player.capabilities.allowFlying = true;
			mc.player.capabilities.setFlySpeed(0.1F);
		}
	}
	public void onDisable() {
		mc.player.capabilities.allowFlying = false;
		mc.player.capabilities.isFlying = false;
	}

}
