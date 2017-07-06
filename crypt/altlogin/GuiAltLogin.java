package crypt.altlogin;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;

public class GuiAltLogin extends GuiScreen{

	private GuiTextField email;
	private GuiTextField pw;
	private GuiTextField emailpw;
	private String logdin = "Logged in.";
	
	@Override
	public void initGui() {
		Keyboard.enableRepeatEvents(true);
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(1, width / 2 - 100, height / 4 + 96 + 18, I18n.format("Login", new Object[0])));
		this.buttonList.add(new GuiButton(2, width / 2 - 100, height / 4 + 96 + 42, I18n.format("Cancel", new Object[0])));
		this.email = new GuiTextField(0, this.fontRendererObj, width / 2 - 100, 66, 200, 20);
		this.pw = new GuiTextField(1, this.fontRendererObj, width / 2 - 100, 101, 200, 20);
		this.emailpw = new GuiTextField(2, this.fontRendererObj, width / 2 - 100, 151, 200, 20);
	}
	
	@Override
	protected void actionPerformed(GuiButton btn) {
		if (btn.id == 1) {
			if (this.email.getText().length() > 0) {
				if (this.pw.getText().length() > 0) {
					this.logdin = "Logging in...";
					this.logdin = LoginThread.login(this.email.getText(), this.pw.getText());
				} else {
					this.logdin = "Logging in...";
					this.logdin = LoginThread.loginCracked(this.email.getText());
				}
			} else if (this.pw.getText().length() <= 0 && this.emailpw.getText().length() > 0 && this.emailpw.getText().contains("i")) {
				this.logdin = "Logging in...";
				this.logdin = LoginThread.login(this.emailpw.getText().split("i")[0], this.emailpw.getText().split("i")[1]);
			}
		} else if (btn.id == 2) {
			this.mc.displayGuiScreen(new GuiMainMenu());
		}
	}
	
	@Override
	public void updateScreen() {
		this.email.updateCursorCounter();
		this.email.setMaxStringLength(100);
		this.pw.updateCursorCounter();
		this.pw.setMaxStringLength(100);
		this.emailpw.updateCursorCounter();
		this.emailpw.getMaxStringLength();
	}
	
	@Override
	public void mouseClicked(int x, int y, int b) {
		this.email.mouseClicked(x, y, b);
		this.pw.mouseClicked(x, y, b);
		this.emailpw.mouseClicked(x, y, b);
		try {
			super.mouseClicked(x, y, b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void keyTyped(char ch, int key) {
		if (key == 1) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiMainMenu());
		}
		this.email.textboxKeyTyped(ch, key);
		this.pw.textboxKeyTyped(ch, key);
		this.emailpw.textboxKeyTyped(ch, key);
		if (key == 28) {
			this.actionPerformed((GuiButton)this.buttonList.get(0));
		}
		if (key == 13) {
			this.actionPerformed((GuiButton)this.buttonList.get(0));
		}
		((GuiButton)this.buttonList.get((int)0)).enabled = this.email.getText().length() > 0 || this.emailpw.getText().length() > 0;
	}
	
	@Override
	public void drawScreen(int x, int y, float f) {
		drawDefaultBackground();
		ScaledResolution s1 = new ScaledResolution(this.mc);
		Gui.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, s1.getScaledWidth(), s1.getScaledHeight(), s1.getScaledWidth(), s1.getScaledHeight());
		
		this.mc.fontRendererObj.drawString(String.valueOf(this.logdin) + this.logdin != "Logging in..." ? new StringBuilder(" (").append(this.mc.session.getUsername()).append(")").toString() : "", 3, 3, 0xffffffff);
		try {
			this.email.drawTextBox();
			this.pw.drawTextBox();
			this.emailpw.drawTextBox();
			this.drawCenteredString(this.fontRendererObj, "AltLogin", width / 2, 20, 0xffffffff);
			if (!this.email.isFocused() && this.email.getText().length() <= 0) {
				this.drawString(this.fontRendererObj, "Email", width / 2 - 100 + 4, 72, 0xffffffff);
			}
			if (!this.pw.isFocused() && this.pw.getText().length() <= 0) {
				this.drawString(this.fontRendererObj, "Password", width / 2 - 100 + 4, 107, 0xffffffff);
			}
			if (!this.emailpw.isFocused() && this.emailpw.getText().length() <= 0) {
				this.drawString(this.fontRendererObj, "Email:Password", width / 2 - 100 + 4, 157, 0xffffffff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.drawScreen(x, y, f);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
