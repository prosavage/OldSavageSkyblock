package net.prosavage.savageskyblock.cmd.commands;

import net.prosavage.savageskyblock.SavageSkyblock;
import net.prosavage.savageskyblock.cmd.AbstractCommand;
import net.prosavage.savageskyblock.util.GeneralUtil;
import org.bukkit.command.CommandSender;

public class CommandSavageSkyblock extends AbstractCommand {

    public CommandSavageSkyblock() {
        super("Skyblock", null, null);
    }

    @Override
    public boolean runCommand(SavageSkyblock instance, CommandSender sender, String... args) {

        sender.sendMessage("");
        sender.sendMessage(GeneralUtil.color("&bSavageSkyblock"));
        sender.sendMessage(GeneralUtil.color("  &7Version " + instance.getDescription().getVersion()));



        return false;
    }





}
