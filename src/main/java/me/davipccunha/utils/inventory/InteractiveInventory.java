package me.davipccunha.utils.inventory;

import me.davipccunha.utils.item.NBTHandler;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InteractiveInventory {
    public static ItemStack createToggleItem(boolean config, Map<String, String> nbtTags, String name, String description) {
        ItemStack wool = new ItemStack(Material.WOOL, 1, (short) (config ? 5 : 14));

        final List<String> lore = Arrays.asList(
                description,
                "§7 Clique para " + (config ? "§cDesativar" : "§aAtivar")
        );

        return createActionItem(wool, nbtTags, name, lore);
    }

    public static ItemStack createActionItem(ItemStack item, Map<String, String> nbtTags, String name, List<String> lore) {
        ItemStack actionItem = NBTHandler.addNBT(item, nbtTags);

        ItemMeta actionItemMeta = actionItem.getItemMeta();
        actionItemMeta.setDisplayName(name);

        actionItemMeta.setLore(lore);
        actionItem.setItemMeta(actionItemMeta);

        return actionItem;
    }
}
