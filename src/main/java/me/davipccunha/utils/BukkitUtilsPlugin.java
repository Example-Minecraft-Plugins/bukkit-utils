package me.davipccunha.utils;

import org.bukkit.plugin.java.JavaPlugin;

public class BukkitUtilsPlugin extends JavaPlugin {
    public static BukkitUtilsPlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        getLogger().info("Utils enabled");
        saveDefaultConfig();
    }

    public void onDisable() {
        getLogger().info("Utils disabled");
    }
}
