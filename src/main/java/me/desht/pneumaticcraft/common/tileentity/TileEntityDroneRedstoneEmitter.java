package me.desht.pneumaticcraft.common.tileentity;

import me.desht.pneumaticcraft.common.core.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;

public class TileEntityDroneRedstoneEmitter extends TileEntity implements ITickableTileEntity {
    public TileEntityDroneRedstoneEmitter() {
        super(ModTileEntities.DRONE_REDSTONE_EMITTER.get());
    }

    @Override
    public void tick() {
        BlockState state = getWorld().getBlockState(getPos());
        for (Direction facing : Direction.VALUES) {
            if (state.getWeakPower(getWorld(), getPos(),  facing) > 0) {
                return;
            }
        }
        getWorld().removeBlock(getPos(), false);
    }
}
