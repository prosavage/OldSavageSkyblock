package net.prosavage.savageskyblock;

import net.prosavage.savageskyblock.cmd.CommandManager;
import net.prosavage.savageskyblock.island.Island;
import net.prosavage.savageskyblock.struct.Grid;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SavageSkyblock extends JavaPlugin {

    private static SavageSkyblock plugin;

    public static SavageSkyblock getInstance() {
        return plugin;
    }

    private Set<Island> islands;


    private Grid grid;

    @Override
    public void onEnable() {
        this.getLogger().info("=== Enable Start ===");
        plugin = this;

        this.prepareConfigFile();

        this.prepareSchematicFiles();

        this.checkDependencies();

        this.grid = new Grid();

        this.getLogger().info("Registering Commands...");
        this.getCommand("skyblock").setExecutor(new CommandManager(this));





    }

    @Override
    public void onDisable() {

    }


    public Grid getGrid() {
        return grid;
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

    private void prepareSchematicFiles() {
        this.getLogger().info("Checking if schematics exist...");
        if (!this.checkIfSchematicFolderExists()) {
            this.getLogger().info("Schematics folder not found!");
            this.getLogger().info("Creating Schematics folder & copying in default schematics...");
            this.saveResource("schematics\\iceisland.schematic", true);
            this.saveResource("schematics\\candylandisland.schematic", true);
            this.saveResource("schematics\\island.schematic", true);
        } else {
            this.getLogger().info("Schematics File Found!");
        }
    }

    private boolean checkIfSchematicFolderExists() {
        File schemDir = new File(getDataFolder().getAbsolutePath() + "\\schematics\\");
        return schemDir.exists();
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
