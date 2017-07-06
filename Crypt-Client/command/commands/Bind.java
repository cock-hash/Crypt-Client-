package haxorus.command.commands;

import org.lwjgl.input.Keyboard;

import haxorus.command.Command;
import haxorus.main.Haxorus;
import haxorus.mods.Mod;

public class Bind extends Command {

	@Override
	public String getAlias() {
		return "bind";
	}
	
	@Override
	public String getDescription() {
		return "Changes keybind of a mod";
	}
	
	@Override
	public String getSyntax() {
		return ".bind set (Mod) (Key) | .bind del (Mod) | .bind clear";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		if (args[0].equalsIgnoreCase("set")) {
			args[2] = args[2].toUpperCase();
			int key = Keyboard.getKeyIndex(args[2]);
			
			for (Mod m : Haxorus.getMods()) {
				if (args[1].equalsIgnoreCase(m.getName())) {
					m.setKey(Keyboard.getKeyIndex(Keyboard.getKeyName(key)));
					Haxorus.addChatMessage(args[1] + " has been binded to " + args[2]);
				}
			}
			
		} else if (args[0].equalsIgnoreCase("del")) {
			for (Mod m : Haxorus.getMods()) {
				m.setKey(0);
				Haxorus.addChatMessage(args[1] + " has been unbinded");
			}
		} else if (args[0].equalsIgnoreCase("clear")) {
			for (Mod m : Haxorus.getMods()) {
				Haxorus.addChatMessage("All keys cleared");
			}
		}
	} 
}
