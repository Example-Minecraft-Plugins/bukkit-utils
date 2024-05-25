package me.davipccunha.utils.server;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class ServerUtils {
    public static void messageEveryone(String message, boolean highlight) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (highlight) player.sendMessage(" ");
            player.sendMessage(message);
            if (highlight) player.sendMessage(" ");
        }
    }

    public static void messageEveryone(List<String> lines, boolean highlight) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (highlight) player.sendMessage(" ");
            for (String line : lines) {
                player.sendMessage(line);
            }
            if (highlight) player.sendMessage(" ");
        }
    }
}
