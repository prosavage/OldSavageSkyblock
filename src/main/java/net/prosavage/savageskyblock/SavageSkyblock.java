package net.prosavage.savageskyblock;

import net.prosavage.savageskyblock.cmd.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;

public class SavageSkyblock extends JavaPlugin {

    private static SavageSkyblock INSTANCE;

    public static SavageSkyblock getInstance() {
        return INSTANCE;
    }

    @Override
    public void onEnable() {
        this.getLogger().info("=== Enable Start ===");
        INSTANCE = this;

        this.prepareConfigFile();

        this.checkDependencies();

        this.getLogger().info("Registering Commands...");
        this.getCommand("skyblock").setExecutor(new CommandManager(this));

        //Set up hooks how ever Example:
        //new HookManager(Arrays.asList(new WorldEditHook(), new VaultHook())));
    }

    @Override
    public void onDisable() {

    }

    private void checkDependencies() {
        List<String> dependencies = this.getDescription().getSoftDepend();

        for (String pluginName : dependencies) {
            if (!this.isPluginAvailable(pluginName)) {
                this.getLogger().info("The plugin \"" + pluginName + "\" is not installed, please install to continue!");
                this.onDisable();
                Bukkit.getPluginManager().disablePlugin(this);
            } else {
                this.getLogger().info("The dependency \"" + pluginName + "\" was found, hooking into it.");
            }

        }
        this.getLogger().info("All dependencies found!");
    }

    private boolean isPluginAvailable(String pluginName) {
        PluginManager pm = Bukkit.getPluginManager();
        Plugin plugin = pm.getPlugin(pluginName.trim());
        return ((plugin != null) && (plugin.isEnabled()));
    }


    private void prepareConfigFile() {
        this.getLogger().info("Checking Configuration File...");
        if (!this.checkIfConfigExists()) {
            this.getLogger().info("Configuration file was not found!");
            this.getLogger().info("Creating config.yml...");
            this.saveResource("config.yml", true);
        } else {
            this.getLogger().info("Configuration File Found!");
        }
    }
    private boolean checkIfConfigExists() {
        File configFile = new File(getDataFolder(), "config.yml");
        return configFile.exists();
    }


}
