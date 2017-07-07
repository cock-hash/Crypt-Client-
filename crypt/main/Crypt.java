package crypt.main;

import java.util.ArrayList;

import crypt.command.CommandManager;
import crypt.mods.*;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.*;

public class Crypt {
	private static ArrayList<Mod> mods;
	private static CommandManager cmdManager;
	
	public Crypt() {
		mods = new ArrayList<Mod>();
		cmdManager = new CommandManager();
		//0
		addMod(new Flight());
		//1
		addMod(new NoFall());
		//2
		addMod(new FullBright());
		//2
		addMod(new HypixelFly());
		//3
		addMod(new NoKnockback());
		//4
		addMod(new Godmode());
		
		
	}
	public static void addMod(Mod m) {
		mods.add(m);
	}
	public static ArrayList<Mod> getMods() {
		return mods;
	}
	public static void onUpdate() {
		for(Mod m: mods) {
			m.onUpdate();
		}
	}
	public static void onRender() {
		for(Mod m: mods) {
			m.onRender();
		}
	}
	public static void onKeyPressed(int i) {
		for(Mod m: mods) {
			if (m.getKey() == i) {
				m.toggle();
			}
		}
	}
	public static void addChatMessage(String s) {
		Minecraft.getMinecraft().player.addChatMessage(new TextComponentString("\2473C\247brypt\247f: " + s));
	}
	
	public static boolean onSendChatMessage(String s) {
		if(s.startsWith(".")) {
			cmdManager.callCommand(s.substring(1));
			return false;
			}
		return true;
		}
	
}
