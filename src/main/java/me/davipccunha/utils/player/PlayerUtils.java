package me.davipccunha.utils.player;

import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class PlayerUtils {
    @NonNull
    public static String correctNameCasing(@NonNull String name) {
        for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
            if (player.getName().equalsIgnoreCase(name)) return player.getName();
        }

        return name;
    }
}
