package me.davipccunha.utils;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitUtilsPlugin extends JavaPlugin {
    public static BukkitUtilsPlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        getLogger().info("Utils enabled");
        saveDefaultConfig();
        this.init();
    }

    public void onDisable() {
        getLogger().info("Utils disabled");
    }

    private void init() {
        this.registerListeners(
        );
        this.registerCommands();
    }

    private void registerListeners(Listener... listeners) {
        PluginManager pluginManager = getServer().getPluginManager();
        for (Listener listener : listeners) pluginManager.registerEvents(listener, this);
    }

    private void registerCommands() {
    }
}
