package sonar.fluxnetworks.common.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import sonar.fluxnetworks.api.network.ISuperAdmin;
import sonar.fluxnetworks.api.utils.Capabilities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CapabilitySAProvider implements ICapabilitySerializable {

    private final ISuperAdmin instance = Capabilities.SUPER_ADMIN.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == Capabilities.SUPER_ADMIN;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == Capabilities.SUPER_ADMIN ? (T) instance : null;
    }


    @Override
    public NBTBase serializeNBT() {
        return Capabilities.SUPER_ADMIN.writeNBT(instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        Capabilities.SUPER_ADMIN.readNBT(instance, null, nbt);
    }
}
