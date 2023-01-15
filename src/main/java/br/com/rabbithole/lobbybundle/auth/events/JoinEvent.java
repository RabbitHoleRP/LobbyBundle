package br.com.rabbithole.lobbybundle.auth.events;

import br.com.rabbithole.lobbybundle.auth.Auth;
import br.com.rabbithole.lobbybundle.auth.entities.LoginProcessEntity;
import br.com.rabbithole.lobbybundle.utils.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.plugin.Plugin;

public class JoinEvent implements Listener {
    final Plugin plugin;

    public JoinEvent(Plugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.joinMessage(StringUtils.formatString(""));
        Player player = event.getPlayer();
        LoginProcessEntity loginProcess = Auth.getLoginProcess().get(player.getName());

        if (loginProcess == null) {
            event.getPlayer().kick(StringUtils.formatString("<red>[Auth]\n Erro de Segurança!\n Por favor entre novamente!"), PlayerKickEvent.Cause.TIMEOUT);
            return;
        }


    }
}
