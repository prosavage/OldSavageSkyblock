package net.prosavage.savageskyblock.hooks;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditAPI;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import net.prosavage.savageskyblock.SavageSkyblock;
import net.prosavage.savageskyblock.util.Schematic;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;


public class WorldEditHook {

    private static final WorldEditPlugin we = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");


    public static void pasteSchematic(Location location, Schematic schematic) {

        File schematicFile = schematic.getSchematicFile();
        EditSession session = we.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(location.getWorld()), 1000000);
        try {
            MCEditSchematicFormat.getFormat(schematicFile).load(schematicFile).paste(session, new Vector(0,200,0), false);
        } catch (MaxChangedBlocksException | com.sk89q.worldedit.data.DataException | IOException e2) {
            e2.printStackTrace();
        }



    }




}
