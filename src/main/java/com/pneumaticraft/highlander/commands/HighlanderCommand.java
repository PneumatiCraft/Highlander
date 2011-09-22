package com.pneumaticraft.highlander.commands;

import com.pneumaticraft.commandhandler.Command;
import com.pneumaticraft.highlander.Highlander;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class HighlanderCommand extends Command {

    protected Highlander plugin;

    public HighlanderCommand(Highlander plugin) {
        super(plugin);
        this.plugin = plugin;
    }

    @Override
    public abstract void runCommand(CommandSender sender, List<String> args);

}
