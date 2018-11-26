package net.prosavage.savageskyblock.hooks;

import net.prosavage.savageskyblock.SavageSkyblock;
import net.prosavage.savageskyblock.hooks.impl.WorldEditHook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 * Created by Michael on 11/25/2018.
 */
public class PluginHookManager {

    private static Map<String, PluginHook> pluginMap = new HashMap<>();
    private List<PluginHook> plugins = Arrays.asList(new WorldEditHook());

    public PluginHookManager() {
        for (PluginHook hook : plugins) {
            if (SavageSkyblock.getInstance().getServer().getPluginManager().getPlugin(hook.getPluginName()) != null) {
                SavageSkyblock.getInstance().getLogger().log(Level.INFO, "successfully hooked " + hook.getPluginName());
                pluginMap.put(hook.getPluginName(), (PluginHook) hook.setup());
            }
        }
    }

    public static Map<String, PluginHook> getPluginMap() {
        return pluginMap;
    }

}