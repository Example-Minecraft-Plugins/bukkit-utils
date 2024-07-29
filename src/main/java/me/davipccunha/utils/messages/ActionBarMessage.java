package me.davipccunha.utils.messages;

import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBarMessage {
    private final PacketPlayOutChat packet;

    public static final ActionBarMessage CLEAR = new ActionBarMessage("");

    public ActionBarMessage(String message) {
        this.packet = new PacketPlayOutChat(new ChatComponentText(
                ChatColor.translateAlternateColorCodes('&', message)
        ), (byte) 2);
    }

    public void send(Player... players) {
        for (Player player : players) {
            if (player == null) continue;
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(this.packet);
        }
    }

    public void sendAll() {
        Bukkit.getOnlinePlayers().forEach(this::send);
    }
}
