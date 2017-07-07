package crypt.mods;

import org.lwjgl.input.Keyboard;

import crypt.main.Category;
import net.minecraft.nbt.NBTTagCompound;

public class Godmode extends Mod {

	public boolean disableDamage;
    public void writeCapabilitiesToNBT(NBTTagCompound tagCompound) {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setBoolean("invulnerable", this.disableDamage);
    }
    
	public Godmode() {
		super("Godmode (unused)", "Godmode (unused)", Keyboard.KEY_G, Category.PLAYER);
	}
	public void onUpdate() {
		if (this.isToggled()) {
		mc.player.capabilities.disableDamage = true;
        NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setBoolean("invulnerable", true);
		}
	}
	public void onDisable() {
		mc.player.capabilities.disableDamage = false;
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setBoolean("invulnerable", false);
	}

}