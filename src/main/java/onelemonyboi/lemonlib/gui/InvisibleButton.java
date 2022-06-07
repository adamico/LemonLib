package onelemonyboi.lemonlib.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.client.gui.widget.ExtendedButton;

import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.client.gui.widget.button.Button.ITooltip;

public class InvisibleButton extends ExtendedButton {
    public int xPos;
    public int yPos;
    protected final ITooltip onTooltip;

    public InvisibleButton(int xPos, int yPos, int width, int height, ITextComponent displayString, IPressable handler) {
        super(xPos, yPos, width, height, displayString, handler);
        this.xPos = xPos;
        this.yPos = yPos;
        this.onTooltip = (button, matrixStack, mouseX, mouseY) -> {};
    }

    public InvisibleButton(int xPos, int yPos, int width, int height, ITextComponent displayString, IPressable handler, ITooltip onTooltip) {
        super(xPos, yPos, width, height, displayString, handler);
        this.xPos = xPos;
        this.yPos = yPos;
        this.onTooltip = onTooltip;
    }

    @Override
    public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        if (this.isHovered()) {
            this.renderToolTip(matrixStack, mouseX, mouseY);
        }
    }

    @Override
    public void renderToolTip(MatrixStack matrixStack, int mouseX, int mouseY) {
        this.onTooltip.onTooltip(this, matrixStack, mouseX, mouseY);
    }
}
