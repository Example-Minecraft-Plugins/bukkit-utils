package me.davipccunha.utils.cache;

import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import me.davipccunha.utils.cache.serializer.ObjectSerializer;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RedisCache<T> {
    private final RedisConnector redisConnector = new RedisConnector();
    private final String redisKey;
    private final Class<T> clazz;

    public void add(String key, T object) {
        key = key.toLowerCase();
        try (Jedis jedis = redisConnector.getJedis()) {
            final Pipeline pipeline = jedis.pipelined();
            pipeline.hset(this.redisKey, key, ObjectSerializer.serialize(object));
            pipeline.sync();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(String key) {
        key = key.toLowerCase();
        if (this.has(key)) {
            try (Jedis jedis = redisConnector.getJedis()) {
                final Pipeline pipeline = jedis.pipelined();
                pipeline.hdel(this.redisKey, key);
                pipeline.sync();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean has(String key) {
        key = key.toLowerCase();
        try (Jedis jedis = redisConnector.getJedis()) {
            Pipeline pipeline = jedis.pipelined();
            Response<Boolean> response = pipeline.hexists(this.redisKey, key);
            pipeline.sync();

            if (response == null || response.get() == null) return false;

            return response.get();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public T get(String key) {
        key = key.toLowerCase();
        try (Jedis jedis = redisConnector.getJedis()) {
            Pipeline pipeline = jedis.pipelined();
            Response<String> response = pipeline.hget(this.redisKey, key);
            pipeline.sync();

            if (response == null || response.get() == null) return null;

            TypeToken<T> typeToken = new TypeToken<T>() {};

            return ObjectSerializer.deserialize(response.get(), this.clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Collection<T> getValues() {
        try (Jedis jedis = redisConnector.getJedis()) {
            Pipeline pipeline = jedis.pipelined();
            Response<Map<String, String>> response = pipeline.hgetAll(this.redisKey);
            pipeline.sync();

            if (response == null || response.get() == null) return null;

            TypeToken<T> typeToken = new TypeToken<T>() {};

            return (Collection<T>) response.get().values().stream().map(value ->
                            ObjectSerializer.deserialize(value, this.clazz))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
