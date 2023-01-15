package br.com.rabbithole.lobbybundle.auth.commands.user;

import br.com.rabbithole.lobbybundle.auth.Auth;
import br.com.rabbithole.lobbybundle.auth.entities.LoginProcessEntity;
import br.com.rabbithole.lobbybundle.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class RegisterCommand implements CommandExecutor {

    final Plugin plugin;

    public RegisterCommand(Plugin plugin) {
        this.plugin = plugin;
        PluginCommand command = Objects.requireNonNull(Bukkit.getPluginCommand("register"));
        command.setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(StringUtils.formatString("<red>[Auth] apenas jogadores podem executar este Comando!"));
            return true;
        }
        LoginProcessEntity loginProcess = Auth.getLoginProcess().get(player.getName());
        if (loginProcess == null) return true;

        if (loginProcess.isRegistered()) {
            player.sendMessage("JÁ REGISTRADO"); //TODO: ADICIONAR MENSAGEM DE JÁ REGISTRADO!
            return true;
        }




        return false;
    }
}
