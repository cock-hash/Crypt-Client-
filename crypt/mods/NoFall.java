package crypt.mods;

import org.lwjgl.input.Keyboard;

import crypt.main.Category;
import net.minecraft.network.play.client.CPacketPlayer;

public class NoFall extends Mod {

	public NoFall() {
		super("NoFall", "NoFall", Keyboard.KEY_N, Category.PLAYER);
	}
	public void onUpdate() {
		if (this.isToggled()) {
			if (mc.player.fallDistance >= 2F) {
				mc.player.connection.sendPacket(new CPacketPlayer(true));
			}
		}
		super.onUpdate();
	}
}
