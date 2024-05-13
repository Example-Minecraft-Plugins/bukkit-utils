package me.davipccunha.utils.player;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.entity.Player;

public class PermissionUtils {
    public static int extractNumberSuffix(String permission) {
        String[] parts = permission.split("\\.");
        String lastPart = parts[parts.length - 1];

        return NumberUtils.toInt(lastPart, -1);
    }

    public static String getLuckPermsPrefix(Player player) {
        final LuckPerms api = LuckPermsProvider.get();
        final String name = player.getName();

        try {
            return api.getUserManager().getUser(name).getCachedData().getMetaData().getPrefix().replaceAll("&", "§");
        } catch (Exception ignored) {
            return "§7[Membro]";
        }
    }
}
