package me.davipccunha.utils.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    @EventHandler
    private void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        String message = ChatColor.translateAlternateColorCodes('&', event.getMessage());
        event.setMessage(message);
    }
}
