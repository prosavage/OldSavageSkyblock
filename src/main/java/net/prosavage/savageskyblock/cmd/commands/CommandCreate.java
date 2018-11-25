package net.prosavage.savageskyblock.cmd.commands;

import net.prosavage.savageskyblock.SavageSkyblock;
import net.prosavage.savageskyblock.cmd.AbstractCommand;
import net.prosavage.savageskyblock.util.GeneralUtil;
import net.prosavage.savageskyblock.util.SetupUtil;
import org.bukkit.command.CommandSender;

public class CommandCreate extends AbstractCommand {

    public CommandCreate(AbstractCommand abstractCommand) {
        super("create", "savageskyblock.islands.create", abstractCommand);
    }

    @Override
    public boolean runCommand(SavageSkyblock instance, CommandSender sender, String... args) {

        if (args.length > 1) {
            sender.sendMessage(GeneralUtil.formattedMessage("Syntax Error..."));
            return true;
        }

        if (args.length == 1) {
            sender.sendMessage(GeneralUtil.formattedMessage("Creating your island..."));
            //TODO: Actually Create the Island.
        }


        return true;
    }



}
