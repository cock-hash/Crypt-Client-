package haxorus.command;

import java.util.ArrayList;

import haxorus.command.commands.*;
import haxorus.main.Haxorus;

public class CommandManager {

	private ArrayList<Command> commands;
	
	public CommandManager() {
		commands = new ArrayList();
		addCommand(new Bind());
	}
	
	public void addCommand(Command c) {
		commands.add(c);
	}
	
	public ArrayList<Command> getCommands() {
		return commands;
	}
	
	public void callCommand(String input) {
		String[] split = input.split(" ");
		String command = split[0];
		String args = input.substring(command.length()).trim();
		for(Command c : getCommands()) {
			if(c.getAlias().equalsIgnoreCase(command)) {
				try {
					c.onCommand(args, args.split(" "));
				} catch(Exception e) {
					Haxorus.addChatMessage("Invalid Command Usage.");
					Haxorus.addChatMessage(c.getSyntax());
				}
				return;
			}
		}
		Haxorus.addChatMessage("Command not found.");
	}
}
