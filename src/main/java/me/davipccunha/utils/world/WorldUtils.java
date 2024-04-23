package me.davipccunha.utils.world;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;

public class WorldUtils {
    public static long chunkHash(int x, int z) {
        x >>= 4;
        z >>= 4;

        return ((long) x << 32) + z - Integer.MIN_VALUE;
    }

    public static int getHighestY(String worldName, int x, int z) {
        World world = Bukkit.getWorld(worldName);
        for (int y = 256; y >= 0; y--) {
            Block block = world.getBlockAt(x, y, z);
            if (!block.isEmpty()) return y;
        }

        return 0;
    }
}
