package me.davipccunha.utils.gui;

import me.davipccunha.utils.general.GeneralUtils;
import me.davipccunha.utils.inventory.InteractiveInventory;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class GUIUtils {
    public static Map<Integer, List<ItemStack>> separateIntoPages(Collection<ItemStack> items, int pageSize) {
        return GeneralUtils.divideList(new ArrayList<>(items), pageSize);
    }

    public static ItemStack previousPageItem(int thisPage) {
        final Map<String, String> nbtTags = Map.of(
            "action", "previous-page",
            "this-page", String.valueOf(thisPage)
        );

        return changePageItem(nbtTags, "§r§ePágina anterior", thisPage);
    }

    public static ItemStack nextPageItem(int thisPage) {
        final Map<String, String> nbtTags = Map.of(
            "action", "next-page",
            "this-page", String.valueOf(thisPage)
        );

        return changePageItem(nbtTags, "§r§ePróxima página", thisPage + 2);
    }

    private static ItemStack changePageItem(Map<String, String> nbtTags, String name, int toPage) {
        final ItemStack arrow = new ItemStack(Material.ARROW);

        final List<String> lore = List.of("§7 Clique para acessar a página " + toPage);

        return InteractiveInventory.createActionItem(arrow, nbtTags, name, lore);
    }
}
