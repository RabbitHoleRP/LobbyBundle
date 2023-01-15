package br.com.rabbithole.lobbybundle.utils;

import br.com.rabbithole.lobbybundle.configuration.RedisConfiguration;
import org.bukkit.Bukkit;
import redis.clients.jedis.Jedis;

import java.util.Optional;

public class RedisUtils {

    /**
     *
     * @param key String para identificar HashSet
     * @param field String para identificar campo da HashSet
     * @param value String a ser adicionado ao Cache
     * @return Retorna valor verdadeiro ou falso identificando resultado do Comando
     */
    public static boolean hashSetQuery(String key, String field, String value) {
        try (Jedis jedis = RedisConfiguration.getJedis().getResource()) {
            jedis.hset(key, field, value);
            return true;
        } catch (Exception exception) {
            Bukkit.getConsoleSender().sendMessage(StringUtils.formatString("<red> Redis Exception!"));
            exception.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param key String para identificar HashSet
     * @param field String para identificar campo da HashSet
     * @return Retorna valor verdadeiro ou falso identificando resultado do Comando
     */
    public static boolean hashDelQuery(String key, String field) {
        try (Jedis jedis = RedisConfiguration.getJedis().getResource()) {
            jedis.hdel(key, field);
            return true;
        } catch (Exception exception) {
            Bukkit.getConsoleSender().sendMessage(StringUtils.formatString("<red> Redis Exception!"));
            exception.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param key String para identificar HashSet
     * @param field String para identificar campo da HashSet
     * @return Retorna valor verdadeiro ou falso identificando resultado do Comando
     */
    public static boolean hashExistsQuery(String key, String field) {
        try (Jedis jedis = RedisConfiguration.getJedis().getResource()) {
            return jedis.hexists(key, field);
        } catch (Exception exception) {
            Bukkit.getConsoleSender().sendMessage(StringUtils.formatString("<red> Redis Exception!"));
            exception.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param key String para identificar HashSet
     * @param field String para identificar campo da HashSet
     * @return //TODO: FAZER DPS <3
     */
    public static Optional<String> hashGetQuery(String key, String field) {
        try (Jedis jedis = RedisConfiguration.getJedis().getResource()) {
            return Optional.of(jedis.hget(key, field));//new ResponseEntity(true, jedis.hget(key, field));
        } catch (Exception exception) {
            Bukkit.getConsoleSender().sendMessage(StringUtils.formatString("<red> Redis Exception!"));
            exception.printStackTrace();
            return Optional.empty();
        }
    }
}
