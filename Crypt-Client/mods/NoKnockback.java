package haxorus.mods;

import org.lwjgl.input.Keyboard;

import haxorus.main.Category;

public class NoKnockback extends Mod {

	public NoKnockback() {
		super("NoKB", "NoKB", Keyboard.KEY_U, Category.PLAYER);
	}
	
	public void onUpdate() {
		if (this.isToggled()) {
			if (mc.player.hurtTime > 0) {
				mc.player.motionX = 0;
				mc.player.motionY = 0;
				mc.player.motionZ = 0;
			}
		}
	}
}
