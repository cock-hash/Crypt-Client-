package crypt.mods;

import org.lwjgl.input.Keyboard;

import crypt.main.Category;
import crypt.main.Crypt;
import net.minecraft.client.Minecraft;

public class HypixelFly extends Mod {

	public HypixelFly() {
		super("Flight", "Flight", Keyboard.KEY_H, Category.MOVEMENT);
	}
	public void onUpdate() {
		if (this.isToggled()) {
			if (mc.gameSettings.keyBindJump.isKeyDown()) {
				mc.player.motionY = 0.4;
			} else if (mc.player.isSneaking()) {
				mc.player.motionY = -0.4;
			} else if (mc.gameSettings.keyBindBack.isPressed() || mc.gameSettings.keyBindForward.isPressed() || mc.gameSettings.keyBindLeft.isPressed() || mc.gameSettings.keyBindRight.isPressed()) {
				mc.player.motionY = 0;
			} else {
				mc.player.motionY = 0;
			}
			mc.player.capabilities.setFlySpeed(0.1F);
		}
	}

}
