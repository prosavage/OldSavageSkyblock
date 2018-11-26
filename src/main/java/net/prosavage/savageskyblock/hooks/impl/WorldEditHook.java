package net.prosavage.savageskyblock.hooks.impl;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditAPI;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import net.prosavage.savageskyblock.SavageSkyblock;
import net.prosavage.savageskyblock.hooks.PluginHook;
import net.prosavage.savageskyblock.util.Schematic;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;


public class WorldEditHook implements PluginHook {

    private SavageSkyblock plugin = SavageSkyblock.getInstance();
    private static final WorldEditPlugin we = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");

    public static void pasteSchematic(Location location, Schematic schematic) {
        File schematicFile = schematic.getSchematicFile();
        EditSession session = we.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(location.getWorld()), 1000000);
        try {
            MCEditSchematicFormat.getFormat(schematicFile).load(schematicFile).paste(session, new Vector(0, 200, 0), false);
        } catch (MaxChangedBlocksException | com.sk89q.worldedit.data.DataException | IOException e2) {
            e2.printStackTrace();
        }

    }

    private boolean checkIfSchematicFolderExists() {
        File schemDir = new File(SavageSkyblock.getInstance().getDataFolder().getAbsolutePath() + "\\schematics\\");
        return schemDir.exists();
    }

    @Override
    public WorldEditHook setup() {
        if (!this.checkIfSchematicFolderExists()) {
            plugin.getLogger().info("Schematics folder not found! creating default schematics....");
//            plugin.saveResource("schematics\\iceisland.schematic", true);
//            plugin.saveResource("schematics\\candylandisland.schematic", true);
            plugin.saveResource("schematics\\island.schematic", true);
        } else {
            plugin.getLogger().info("Schematics File Found!");
        }
        return this;
    }

    @Override
    public String getPluginName() {
        return "WorldEdit";
    }
}
