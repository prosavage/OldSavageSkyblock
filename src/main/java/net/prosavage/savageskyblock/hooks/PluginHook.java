package net.prosavage.savageskyblock.hooks;

/**
 * Created by Michael on 11/25/2018.
 */
public interface PluginHook<T> {

    T setup();

    String getPluginName();

}
