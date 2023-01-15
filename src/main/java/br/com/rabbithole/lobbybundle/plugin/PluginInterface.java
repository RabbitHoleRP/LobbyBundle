package br.com.rabbithole.lobbybundle.plugin;

public interface PluginInterface {

    /**
     *
     * Utilizado para declarar a rotina de ativação do Plugin
     */
    void onEnable();

    /**
     *
     * Utilizado para declarar a rotina de desativação do Plugin
     */
    void onDisable();
    /**
     *
     * Utilizado para registrar informações do Plugin
     */
    default void registers() {
        commands();
        events();
    }

    /**
     *
     * Utilizado para registrar comandos do Plugin
     */
    void commands();

    /**
     *
     * Utilizado para registrar eventos do Plugin
     */
    void events();
}
