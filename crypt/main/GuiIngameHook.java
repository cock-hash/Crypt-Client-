package crypt.main;


import crypt.mods.Mod;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class GuiIngameHook extends GuiIngame {

	public GuiIngameHook (Minecraft mcIn) {
		super(mcIn);
	}
	
    public void renderGameOverlay(float partialTicks) {
    	super.renderGameOverlay(partialTicks);
        ScaledResolution scaledresolution = new ScaledResolution(this.mc);
        FontRenderer fontrenderer = this.getFontRenderer();
        GlStateManager.enableBlend();
        mc.fontRendererObj.drawString("\2479Hax\247borus", 383, 2, 0xffffff);
        int count = 0;
        
        Random rand = new Random();
        float r = rand.nextFloat() / 4f + 0.5f;
        float g = rand.nextFloat() / 4f + 0.5f;
        float b = rand.nextFloat() / 2f;
        
        
        for(Mod m : Crypt.getMods()) {
        	if (m.isToggled()) {
        		int right = scaledresolution.getScaledWidth() - mc.fontRendererObj.getStringWidth(m.getArrayListName());
				mc.fontRendererObj.drawString(m.getName(), right - 2, 12 + (count*12), 0xffffff);
        		count++;
        	}

        }
    }
}
