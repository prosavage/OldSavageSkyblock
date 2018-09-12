package net.prosavage.savageskyblock.util;

import net.prosavage.savageskyblock.SavageSkyblock;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupUtil {


    public static void performSetup(CommandSender sender) {
        sender.sendMessage(GeneralUtil.color("&7============================"));
        sender.sendMessage(GeneralUtil.formattedMessage("Attempting Setup..."));

        if (checkIfSkyblockWorldExists()) {
            sender.sendMessage(GeneralUtil.formattedMessage("The skyblock world already exists, cancelling setup."));
        } else {
            sender.sendMessage(GeneralUtil.formattedMessage("The skyblock world does not exist, creating one now...."));
            SetupUtil.createVoidWorld(SavageSkyblock.getInstance().getConfig().getString("skyblock-world-name"));
            sender.sendMessage(GeneralUtil.formattedMessage("Created skyblock world!"));
            //TODO: Remove the test code.
            // Testing code by placing 1 bedrock and teleporting to spawn location
            GeneralUtil.getSkyblockWorld().getBlockAt(new Location( GeneralUtil.getSkyblockWorld(), 0, 0, 0)).setType(MultiversionMaterials.BEDROCK.parseMaterial());
            if (sender instanceof Player) {
                sender.sendMessage(GeneralUtil.formattedMessage("Teleporting to world!"));
                ((Player) sender).teleport(new Location(GeneralUtil.getSkyblockWorld(), 0, 3, 0));
            }
            sender.sendMessage(GeneralUtil.formattedMessage("Setup Finished!"));
        }
        sender.sendMessage(GeneralUtil.color("&7============================"));
    }

    public static void createVoidWorld(String name) {
        WorldCreator wc = new WorldCreator(name);
        wc.type(WorldType.FLAT);
        wc.generatorSettings("2;0;1;");
        wc.createWorld();
    }

    public static boolean checkIfSkyblockWorldExists() {
        return Bukkit.getWorld(SavageSkyblock.getInstance().getConfig().getString("skyblock-world-name")) != null;
    }


}
