package br.com.rabbithole.lobbybundle;

import br.com.rabbithole.lobbybundle.configuration.RedisConfiguration;
import br.com.rabbithole.lobbybundle.configuration.WormConfiguration;
import br.com.rabbithole.lobbybundle.plugin.PluginRegister;
import br.com.rabbithole.lobbybundle.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyBundle extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(StringUtils.formatString("<green>[LobbyBundle] iniciado com Sucesso!"));
        registers();
        PluginRegister.enablePlugins();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(StringUtils.formatString("<red>[LobbyBundle] desativado com Sucesso!"));
        PluginRegister.disablePlugins();
    }

    void registers() {
        saveDefaultConfig();
        commands();
        events();
        WormConfiguration.init(this);
        RedisConfiguration.init(this);
    }

    void commands() {}

    void events() {}

    public static LobbyBundle getInstance() {
        return LobbyBundle.getPlugin(LobbyBundle.class);
    }
}
