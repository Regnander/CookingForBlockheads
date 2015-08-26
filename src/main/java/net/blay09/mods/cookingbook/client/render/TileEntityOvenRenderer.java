package net.blay09.mods.cookingbook.client.render;

import net.blay09.mods.cookingbook.block.TileEntityCookingOven;
import net.blay09.mods.cookingbook.block.TileEntityToolRack;
import net.blay09.mods.cookingbook.client.model.ModelOven;
import net.blay09.mods.cookingbook.client.model.ModelToolRack;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class TileEntityOvenRenderer extends TileEntitySpecialRenderer {

    private static final ResourceLocation texture = new ResourceLocation("cookingbook", "textures/entity/ModelOven.png");

    private ModelOven model = new ModelOven();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float delta) {
        TileEntityCookingOven tileEntityOven = (TileEntityCookingOven) tileEntity;
        int metadata = 0;
        if(tileEntity.hasWorldObj()) {
            metadata = tileEntity.getBlockMetadata();
        }
        GL11.glPushMatrix();
        boolean oldRescaleNormal = GL11.glIsEnabled(GL12.GL_RESCALE_NORMAL);
        if(oldRescaleNormal) {
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        }
        GL11.glColor4f(1f, 1f, 1f, 1f);
        GL11.glTranslatef((float) x, (float) y + 1f, (float) z);
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        float angle;
        switch(ForgeDirection.getOrientation(metadata)) {
            case NORTH:
                angle = 0;
                break;
            case EAST:
                angle = -90;
                break;
            case SOUTH:
                angle = 180;
                break;
            case WEST:
                angle = 90;
                break;
            default:
                angle = 180;
        }
        GL11.glRotatef(angle, 0f, 1f, 0f);
        GL11.glRotatef(180f, 0f, 0f, 1f);
        bindTexture(texture);
        model.renderAll();
        GL11.glRotatef(180f, 0f, 0f, -1f);
        if(tileEntityOven.getStackInSlot(16) != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.25f, -0.5f, 0.1f);
            GL11.glRotatef(45f, 1f, 0f, 0f);
            RenderManager.instance.renderEntityWithPosYaw(tileEntityOven.getRenderItem(0), 0, 0, 0, 0f, 0f);
            GL11.glPopMatrix();
        }
        if(tileEntityOven.getStackInSlot(17) != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.25f, -0.5f, 0.1f);
            GL11.glRotatef(45f, 1f, 0f, 0f);
            RenderManager.instance.renderEntityWithPosYaw(tileEntityOven.getRenderItem(1), 0, 0, 0, 0f, 0f);
            GL11.glPopMatrix();
        }
        if(tileEntityOven.getStackInSlot(18) != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.25f, -0.5f, -0.4f);
            GL11.glRotatef(45f, 1f, 0f, 0f);
            RenderManager.instance.renderEntityWithPosYaw(tileEntityOven.getRenderItem(2), 0, 0, 0, 0f, 0f);
            GL11.glPopMatrix();
        }
        if(tileEntityOven.getStackInSlot(19) != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.25f, -0.5f, -0.4f);
            GL11.glRotatef(45f, 1f, 0f, 0f);
            RenderManager.instance.renderEntityWithPosYaw(tileEntityOven.getRenderItem(3), 0, 0, 0, 0f, 0f);
            GL11.glPopMatrix();
        }
        if(!oldRescaleNormal) {
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        }
        GL11.glPopMatrix();
        GL11.glColor4f(1f, 1f, 1f, 1f);
    }

}