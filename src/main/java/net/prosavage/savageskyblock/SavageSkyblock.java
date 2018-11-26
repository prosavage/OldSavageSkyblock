package net.prosavage.savageskyblock;

import net.prosavage.savageskyblock.cmd.CommandManager;
import net.prosavage.savageskyblock.hooks.PluginHookManager;
import net.prosavage.savageskyblock.island.Island;
import net.prosavage.savageskyblock.struct.Grid;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;
import java.util.Set;

public class SavageSkyblock extends JavaPlugin {

    private static SavageSkyblock plugin;

    public static SavageSkyblock getInstance() {
        return plugin;
    }

    private static PluginHookManager pluginHookManager;

    private Set<Island> islands;

    private Grid grid;

    @Override
    public void onEnable() {
        this.getLogger().info("=== Enable Start ===");
        plugin = this;

        this.prepareConfigFile();
        this.grid = new Grid();

        this.getLogger().info("Registering Commands...");
        this.getCommand("skyblock").setExecutor(new CommandManager(this));

        if (hasDependencies()) pluginHookManager = new PluginHookManager();
    }

    private boolean hasDependencies() {
        List<String> dependencies = this.getDescription().getSoftDepend();
        for (String pluginName : dependencies) {
            if (!this.isPluginAvailable(pluginName)) {
                this.getLogger().info("The plugin \"" + pluginName + "\" is not installed, please install to continue!");
                Bukkit.getPluginManager().disablePlugin(this);
                return false;
            }
        }
        return true;
    }

    private boolean isPluginAvailable(String pluginName) {
        PluginManager pm = Bukkit.getPluginManager();
        Plugin plugin = pm.getPlugin(pluginName.trim());
        return ((plugin != null) && (plugin.isEnabled()));
    }

    @Override
    public void onDisable() {}

    public Grid getGrid() {
        return grid;
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

    public Set<Island> getIslands() {
        return islands;
    }

    public void setIslands(Set<Island> islands) {
        this.islands = islands;
    }
}
