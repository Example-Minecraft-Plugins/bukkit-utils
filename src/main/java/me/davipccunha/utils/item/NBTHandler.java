package me.davipccunha.utils.item;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class NBTHandler {
    public static ItemStack addNBT(ItemStack item, Map<String, String> keyValuesPairs) {
        if (item == null) return null;

        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        if (nmsItem == null) return null;

        NBTTagCompound compound = nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound();

        for (String key : keyValuesPairs.keySet()) {
            String value = keyValuesPairs.get(key);
            compound.setString(key, value);
        }

        nmsItem.setTag(compound);

        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    public static String getNBT(ItemStack item, String key) {
        if (item == null) return null;

        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound compound = nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound();

        return compound.hasKey(key) ? compound.getString(key) : null;
    }

    public static ItemStack removeNBT(ItemStack item, String key) {
        if (item == null) return null;

        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        if (nmsItem == null) return null;

        if (!nmsItem.hasTag()) return item;

        NBTTagCompound compound = nmsItem.getTag();

        compound.remove(key);

        nmsItem.setTag(compound);

        return CraftItemStack.asBukkitCopy(nmsItem);
    }
}
