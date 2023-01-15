package br.com.rabbithole.lobbybundle.configuration;

import org.bukkit.plugin.Plugin;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class RedisConfiguration {
    private static JedisPool jedis;

    public static void init(Plugin plugin) {
        String host = plugin.getConfig().getString("Redis.Host");
        int port = plugin.getConfig().getInt("Redis.Port");
        String password = plugin.getConfig().getString("Redis.Password");
        jedis = new JedisPool(buildPoolConfig(), host, port, "default", password);
    }

    private static JedisPoolConfig buildPoolConfig() {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);
        return poolConfig;
    }

    public static JedisPool getJedis() {
        return jedis;
    }
}
