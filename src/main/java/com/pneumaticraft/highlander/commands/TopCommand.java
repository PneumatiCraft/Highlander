package com.pneumaticraft.highlander.commands;

import com.pneumaticraft.highlander.Highlander;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

import java.util.List;

/**
 * Multiverse 2
 *
 * @author fernferret
 */
public class TopCommand extends HighlanderCommand {
    public TopCommand(Highlander plugin) {
        super(plugin);
        this.setName("There can be only one.");
        this.setCommandUsage("/hi top");
        this.setArgRange(0, 0);
        this.addKey("hi top");
        this.addKey("hitop");
        this.setPermission("highlander.top", "There can be only one.", PermissionDefault.TRUE);
    }

    private Player first = null;
    private Player second = null;
    private Player third = null;

    @Override
    public void runCommand(CommandSender sender, List<String> args) {
        first = null;
        second = null;
        third = null;
        for (Player p : this.plugin.getServer().getOnlinePlayers()) {
            if (first == null || p.getLevel() > first.getLevel()) {
                moveDownFromFirst();
                first = p;
            } else if (second == null || p.getLevel() > second.getLevel()) {
                moveDownFromSecond();
                second = p;
            } else if (third == null || p.getLevel() > third.getLevel()) {
                third = p;
            }
        }
        if (first != null) {
            sender.sendMessage("First : " + this.first.getName());
            if (second != null)
                sender.sendMessage("Second: " + this.second.getName());
            if (third != null)
                sender.sendMessage("Third : " + this.third.getName());
        } else {
            sender.sendMessage("No players are online :(");
        }

    }

    private void moveDownFromFirst() {
        this.moveDownFromSecond();
        this.second = this.first;

    }

    private void moveDownFromSecond() {
        this.third = this.second;
    }
}
