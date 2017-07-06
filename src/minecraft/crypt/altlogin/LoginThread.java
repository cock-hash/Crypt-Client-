package crypt.altlogin;

import java.net.Proxy;

import com.google.gson.JsonParser;
import com.mojang.authlib.Agent;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

public class LoginThread {

	public static JsonParser jsonParser = new JsonParser();
	public static String login(String Username, String Password) {
		if (Username.equals("")) {
			return "Login failed.";
		}
		if (Password.equals("")) {
			return "Login failed.";
		}
		YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
		YggdrasilUserAuthentication user = new YggdrasilUserAuthentication(service, Agent.MINECRAFT);
		user.setUsername(Username);
		user.setPassword(Password);
		try {
			user.logIn();
			String playerName = user.getSelectedProfile().getName();
			String playerID = user.getSelectedProfile().getId().toString();
			String token = user.getAuthenticatedToken();
			Minecraft.getMinecraft().session = new Session(playerName, Minecraft.getMinecraft().session.getPlayerID(), Minecraft.getMinecraft().session.getToken(), "mojang");
			return "Logged in.";
		} catch (Exception e) {
			return "Login failed.";
		}
	}
	
	public static String loginCracked(String Username) {
		Minecraft.getMinecraft().session = new Session(Username, Minecraft.getMinecraft().session.getPlayerID(), Minecraft.getMinecraft().session.getToken(), "mojang");
		return "Logged in.";
	}
}
