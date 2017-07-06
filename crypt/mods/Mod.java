package crypt.mods;

import crypt.main.Category;
import net.minecraft.client.Minecraft;

public class Mod {
	public static Minecraft mc = Minecraft.getMinecraft();
	private String Name;
	private String ArrayListName;
	private int key;
	private boolean toggled;
	private Category category;
	
	public Mod(String m, String an, int i, Category c) {
		Name = m;
		ArrayListName = an;
		key = i;
		category = c;
		toggled = false;
	}
	public void toggle() {
		onToggle();
		toggled = !toggled;
		if (toggled) {
			onEnable();
		} else {
			onDisable();
		}
	}
	public void onEnable() {}
	public void onDisable() {}
	public void onUpdate() {}
	public void onRender() {}
	public void onToggle() {}
	
	public Minecraft getMc() {
		return mc;
	}
	public void setMc(Minecraft mc) {
		this.mc = mc;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getArrayListName() {
		return ArrayListName;
	}
	public void setArrayListName(String ArrayListName) {
		this.ArrayListName = ArrayListName;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public boolean isToggled() {
		return toggled;
	}
	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}
	public Category getCategory() {
		return category;
	}

}
