package me.davipccunha.utils.inventory;

import me.davipccunha.utils.item.NBTHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InteractiveInventory {
    public @Nullable static ItemStack createToggleItem(boolean config, Map<String, String> nbtTags, String name, String description) {
        ItemStack wool = new ItemStack(Material.WOOL, 1, (short) (config ? 5 : 14));

        final List<String> lore = Arrays.asList(
                description,
                "§7 Clique para " + (config ? "§cDesativar" : "§aAtivar")
        );

        return createActionItem(wool, nbtTags, name, lore);
    }

    public @Nullable static ItemStack createActionItem(ItemStack item, Map<String, String> nbtTags, String name, List<String> lore) {

        ItemStack actionItem = NBTHandler.addNBT(item, nbtTags);

        if (actionItem == null) return null;

        ItemMeta actionItemMeta = actionItem.getItemMeta();
        actionItemMeta.setDisplayName(name);

        actionItemMeta.setLore(lore);
        actionItem.setItemMeta(actionItemMeta);

        return actionItem;
    }

    public @Nullable static ItemStack createBackItem(String inventory) {
        ItemStack backItem = new ItemStack(Material.ARROW);

        final Map<String, String> nbtTags = Map.of("action", "back", "inventory", inventory);

        final List<String> lore = List.of(
                "§7 Clique para voltar ao menu anterior"
        );

        return createActionItem(backItem, nbtTags,  "§eVoltar", lore);
    }

    public static Inventory createConfirmationInventory(String title, Map<String, String> confirmNBTTags, Map<String, String> cancelNBTTags) {
        final Inventory inventory = Bukkit.createInventory(null, 3 * 9, title);

        final ItemStack confirmItem = new ItemStack(Material.WOOL, 1, (short) 5);
        final ItemStack cancelItem = new ItemStack(Material.WOOL, 1, (short) 14);

        final List<String> confirmLore = List.of("§7 Clique para confirmar");
        final List<String> cancelLore = List.of("§7 Clique para cancelar");

        final ItemStack confirmActionItem = createActionItem(confirmItem, confirmNBTTags, "§aConfirmar", confirmLore);
        final ItemStack cancelActionItem = createActionItem(cancelItem, cancelNBTTags, "§cCancelar", cancelLore);

        inventory.setItem(11, confirmActionItem);
        inventory.setItem(15, cancelActionItem);

        return inventory;
    }
}
