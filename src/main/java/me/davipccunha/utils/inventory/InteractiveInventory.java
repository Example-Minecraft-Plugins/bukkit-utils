package me.davipccunha.utils.inventory;

import me.davipccunha.utils.item.NBTHandler;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InteractiveInventory {
    @Nullable
    public static ItemStack createToggleItem(boolean config, Map<String, String> nbtTags, String name, String description) {
        ItemStack wool = new ItemStack(Material.WOOL, 1, (short) (config ? 5 : 14));

        final List<String> lore = Arrays.asList(
                description,
                "§7 Clique para " + (config ? "§cDesativar" : "§aAtivar")
        );

        return createActionItem(wool, nbtTags, name, lore);
    }

    @Nullable
    public static ItemStack createActionItem(ItemStack item, Map<String, String> nbtTags, String name, List<String> lore) {

        ItemStack actionItem = NBTHandler.addNBT(item, nbtTags);

        if (actionItem == null) return null;

        ItemMeta actionItemMeta = actionItem.getItemMeta();
        actionItemMeta.setDisplayName(name);

        actionItemMeta.setLore(lore);
        actionItem.setItemMeta(actionItemMeta);

        return actionItem;
    }
}
