/******************************************************************************
 * Multiverse 2 Copyright (c) the Multiverse Team 2011.                       *
 * Multiverse 2 is licensed under the BSD License.                            *
 * For more information please check the README.md file included              *
 * with this project.                                                         *
 ******************************************************************************/

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
