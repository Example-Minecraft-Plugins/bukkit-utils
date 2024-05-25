package me.davipccunha.utils.player;

import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerUtils {
    public static @NonNull String correctNameCasing(@NonNull String name) {
        final Player player = Bukkit.getPlayer(name);

        if (player == null) return name;
        return player.getName();
    }
}
