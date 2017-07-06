package haxorus.main;

import java.util.ArrayList;

import haxorus.command.CommandManager;
import haxorus.mods.*;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.*;

public class Haxorus {
	private static ArrayList<Mod> mods;
	private static CommandManager cmdManager;
	
	public Haxorus() {
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
		Minecraft.getMinecraft().player.addChatMessage(new TextComponentString("\2479Hax\247borus\247f: " + s));
	}
	
	public static boolean onSendChatMessage(String s) {
		if(s.startsWith(".")) {
			cmdManager.callCommand(s.substring(1));
			return false;
		}
		for(Mod m : getMods()) {
			if(m.isToggled()) {
				return onSendChatMessage(s);
			}
		}
		return true;
	}
	
	public static boolean onRecieveChatMessage(SPacketChat packet) {
		for(Mod m : getMods()) {
			if(m.isToggled()) {
				return onRecieveChatMessage(packet);
			}
		}
		return true;
	}
	
	
}
