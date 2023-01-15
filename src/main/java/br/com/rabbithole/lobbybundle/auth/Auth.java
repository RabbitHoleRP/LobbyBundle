package br.com.rabbithole.lobbybundle.auth;

import br.com.rabbithole.lobbybundle.auth.entities.LoginProcessEntity;
import br.com.rabbithole.lobbybundle.auth.events.JoinEvent;
import br.com.rabbithole.lobbybundle.auth.events.PreLoginEvent;
import br.com.rabbithole.lobbybundle.plugin.PluginInterface;
import br.com.rabbithole.lobbybundle.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class Auth implements PluginInterface {
    final Plugin plugin;
    private static final HashMap<String, LoginProcessEntity> loginProcess = new HashMap<>();

    public Auth(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(StringUtils.formatString("<green>[Auth] iniciado com Sucesso!"));
        registers();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(StringUtils.formatString("<red>[Auth] desativado com Sucesso!"));
    }

    @Override
    public void commands() {
    }

    @Override
    public void events() {
        new JoinEvent(plugin);
        new PreLoginEvent(plugin);
    }

    public static HashMap<String, LoginProcessEntity> getLoginProcess() {
        return loginProcess;
    }
}
