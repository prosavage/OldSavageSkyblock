package net.prosavage.savageskyblock;

import net.prosavage.savageskyblock.cmd.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class SavageSkyblock extends JavaPlugin {

    private static SavageSkyblock INSTANCE;

    public static SavageSkyblock getInstance() {
        return INSTANCE;
    }

    @Override
    public void onEnable() {
        this.getLogger().info("=== Enable Start ===");
        INSTANCE = this;

        this.getLogger().info("Checking Configuration File...");
        if (!checkIfConfigExists()) {
            this.getLogger().info("Configuration file was not found!");
            this.getLogger().info("Creating config.yml...");
            this.saveResource("config.yml", true);
        } else {
            this.getLogger().info("Configuration File Found!");
        }


        this.getLogger().info("Registering Commands...");
        this.getCommand("EpicSpawners").setExecutor(new CommandManager(this));
    }

    @Override
    public void onDisable() {

    }


    private boolean checkIfConfigExists() {
        File configFile = new File(getDataFolder(), "config.yml");
        return configFile.exists();
    }




}
