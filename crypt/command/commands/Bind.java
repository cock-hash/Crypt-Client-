package crypt.command.commands;

import org.lwjgl.input.Keyboard;

import crypt.command.Command;
import crypt.main.Crypt;
import crypt.mods.Mod;

public class Bind extends Command {

	@Override
	public String getAlias() {
		return "michi";
	}
	
	@Override
	public String getDescription() {
		return "Changes keybind of a mod";
	}
	
	@Override
	public String getSyntax() {
		return ".michi set (Mod) (Key) | .bind del (Mod) | .michi clear";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		
	switch(args[0]){
		case "set":
			args[2] = args[2].toUpperCase();
			int key = Keyboard.getKeyIndex(args[2]);
			
			for (Mod m : Crypt.getMods()) {
				if (args[1].equalsIgnoreCase(m.getName())) {
					m.setKey(Keyboard.getKeyIndex(Keyboard.getKeyName(key)));
					Crypt.addChatMessage(args[1] + " has been binded to " + args[2]);
				}
			}
			break;
		
		case "del":
			for (Mod m : Crypt.getMods()) {
				if(args[1].equalsIgnoreCase(m.getName()))
					m.setKey(0);
			}
			Crypt.addChatMessage(args[1] + " has been unbinded");
			break;
		case "clear":
			for (Mod m : Crypt.getMods()) {
				m.setKey(0);
			}
			Crypt.addChatMessage("All keys cleared");
			break;
		default:
			Crypt.addChatMessage("Sintaxis incorrecta.");
		}
	} 
}
