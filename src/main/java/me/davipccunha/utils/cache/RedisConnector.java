package me.davipccunha.utils.cache;

import me.davipccunha.utils.BukkitUtilsPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnector {
    private final JedisPool pool;

    public RedisConnector() {
        flush();
        final String host = BukkitUtilsPlugin.INSTANCE.getConfig().getString("redis.host");
        final int port = BukkitUtilsPlugin.INSTANCE.getConfig().getInt("redis.port");
        final String user = BukkitUtilsPlugin.INSTANCE.getConfig().getString("redis.user");
        final String password = BukkitUtilsPlugin.INSTANCE.getConfig().getString("redis.password");

        this.pool = new JedisPool(defaultPoolConfig(), host, port, user, password);
    }

    public Jedis getJedis() {
        return this.pool.getResource();
    }

    public boolean isConnected() {
        return (this.pool != null && !this.pool.isClosed());
    }

    public void flush(Runnable... actions) {
        if (actions != null) {
            for (Runnable action : actions) {
                action.run();
            }
        }

        if (this.pool != null) {
            pool.close();
        }
    }

    private JedisPoolConfig defaultPoolConfig() {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);
        return poolConfig;
    }
}
