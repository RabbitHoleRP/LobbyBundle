package br.com.rabbithole.lobbybundle.plugin;

import br.com.rabbithole.lobbybundle.LobbyBundle;
import br.com.rabbithole.lobbybundle.auth.Auth;

public class PluginRegister {
    private static final Auth auth = new Auth(LobbyBundle.getInstance());
    public static void enablePlugins() {
        auth.onEnable();
    }

    public static void disablePlugins() {
        auth.onDisable();
    }
}
