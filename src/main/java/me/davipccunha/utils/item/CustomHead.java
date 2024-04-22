package me.davipccunha.utils.item;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Base64;
import java.util.UUID;

public class CustomHead {
    public static ItemStack getCustomHead(String name, String URL, UUID profileUUID) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();

        if (meta == null) return null;

        meta.setOwner(URL);
        meta.setDisplayName(name);

        byte[] data = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", URL).getBytes());

        GameProfile profile = new GameProfile(profileUUID, null);

        profile.getProperties().put("textures", new Property("textures", new String(data)));

        try {
            Field field = meta.getClass().getDeclaredField("profile");

            field.setAccessible(true);
            field.set(meta, profile);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        skull.setItemMeta(meta);
        return skull;
    }

    public static ItemStack getPlayerHead(String name) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();

        if (meta == null) return null;

        meta.setOwner(name);
        skull.setItemMeta(meta);
        return skull;
    }
}
