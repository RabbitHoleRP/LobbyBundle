package br.com.rabbithole.lobbybundle.auth.events;

import br.com.rabbithole.lobbybundle.auth.Auth;
import br.com.rabbithole.lobbybundle.auth.data.sql.tables.AuthTable;
import br.com.rabbithole.lobbybundle.auth.entities.LoginProcessEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.plugin.Plugin;

public class PreLoginEvent implements Listener {
    final Plugin plugin;

    public PreLoginEvent(Plugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPreLogin(AsyncPlayerPreLoginEvent event) {
        LoginProcessEntity loginProcess;
        try (AuthTable account = new AuthTable(event.getName())) {
            if (account.find()) {
                loginProcess = new LoginProcessEntity(true, false, event.getAddress());
            } else {
                loginProcess = new LoginProcessEntity(false, false, event.getAddress(), 3);
            }
        }
        Auth.getLoginProcess().put(event.getName(), loginProcess);
    }
}
