package net.prosavage.savageskyblock.island;

import net.prosavage.savageskyblock.SavageSkyblock;
import org.bukkit.Location;


import java.util.UUID;

public class Island {



    Plot plot;
    int islandID;
    UUID ownerUUID;
    Location islandCenter;

    public Island(UUID ownerUUID, Plot plot, Location islandCenter) {
        this.plot = plot;
        this.ownerUUID = ownerUUID;
        this.islandCenter = islandCenter;



    }


    public int getIslandID() {
        return this.islandID;
    }
    public Plot getPlot() {
        return this.plot;
    }








}
