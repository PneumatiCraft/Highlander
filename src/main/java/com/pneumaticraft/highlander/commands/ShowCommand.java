package com.pneumaticraft.highlander.commands;

import com.pneumaticraft.highlander.Highlander;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

import java.util.List;

/**
 * Multiverse 2
 *
 * @author fernferret
 */
public class ShowCommand extends HighlanderCommand {
    public ShowCommand(Highlander plugin) {
        super(plugin);
        this.setName("Show how much exp you have.");
        this.setCommandUsage("/hi xp");
        this.setArgRange(0, 0);
        this.addKey("hi xp");
        this.addKey("hixp");
        this.setPermission("highlander.show", "Shows how much EXP you have.", PermissionDefault.TRUE);
    }

    @Override
    public void runCommand(CommandSender sender, List<String> args) {
        if (sender instanceof Player) {
            sender.sendMessage("You have " + ChatColor.AQUA + ((Player) sender).getTotalExperience());
            sender.sendMessage("Level " + ChatColor.AQUA + ((Player) sender).getLevel());
            sender.sendMessage("Only " + ChatColor.AQUA + ((Player) sender).getExperience() +
                    ChatColor.WHITE + " to level "+ ChatColor.AQUA + (((Player) sender).getLevel()+1));
        } else {
            sender.sendMessage("Sorry, this must be run as a player.");
        }
    }
}
