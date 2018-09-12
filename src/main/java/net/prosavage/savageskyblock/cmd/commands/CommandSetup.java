package net.prosavage.savageskyblock.cmd.commands;

import net.prosavage.savageskyblock.SavageSkyblock;
import net.prosavage.savageskyblock.cmd.AbstractCommand;
import net.prosavage.savageskyblock.util.GeneralUtil;
import net.prosavage.savageskyblock.util.MultiversionMaterials;
import net.prosavage.savageskyblock.util.SetupUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetup extends AbstractCommand {

    public CommandSetup(AbstractCommand abstractCommand) {
        super("setup", "savageskyblock.admin.setup", abstractCommand);
    }

    @Override
    public boolean runCommand(SavageSkyblock instance, CommandSender sender, String... args) {

        if (args.length > 1) {
            sender.sendMessage(GeneralUtil.formattedMessage("Syntax Error..."));
            return true;
        }

        if (args.length == 1) {
            SetupUtil.performSetup(sender);
        }


        return true;
    }


}
