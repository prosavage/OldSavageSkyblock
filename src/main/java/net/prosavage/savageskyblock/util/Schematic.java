package net.prosavage.savageskyblock.util;

import net.prosavage.savageskyblock.SavageSkyblock;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class Schematic {

    private final String SCHEMATIC_FOLDER = SavageSkyblock.getInstance().getDataFolder() + "/schematics/";
    private File SchematicFile;

    public Schematic(String SchematicFileName) {
        this.SchematicFile = new File(SCHEMATIC_FOLDER, SchematicFileName + ".schematic");
    }

    public File getSchematicFile() {
        return this.SchematicFile;
    }









}
