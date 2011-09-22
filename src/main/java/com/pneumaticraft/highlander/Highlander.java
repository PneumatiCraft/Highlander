package com.pneumaticraft.highlander;

import com.pneumaticraft.commandhandler.CommandHandler;
import com.pneumaticraft.highlander.commands.HelpCommand;
import com.pneumaticraft.highlander.commands.ShowCommand;
import com.pneumaticraft.highlander.commands.TopCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Highlander extends JavaPlugin {
    private CommandHandler commandHandler;
    private HPermissions permissions;
    private Configuration config;
    private boolean fix;

    @Override
    public void onEnable() {
        this.permissions = new HPermissions(this);
        this.commandHandler = new CommandHandler(this, permissions);
        this.registerCommands();
        this.getDataFolder().mkdirs();
        this.loadConfigs();

    }

    private void registerCommands() {
        // Intro Commands
        this.commandHandler.registerCommand(new HelpCommand(this));
        this.commandHandler.registerCommand(new ShowCommand(this));
        this.commandHandler.registerCommand(new TopCommand(this));

    }

    @Override
    public void onDisable() {
    }

    public void loadConfigs() {
        this.config = new Configuration(new File(getDataFolder(), "config.yml"));
    }

    public void setPlayerLevel(String name, int level) {
        this.config.setProperty("players." + name + ".level", level);
        this.config.save();
    }

    public CommandHandler getCommandHandler() {
        return this.commandHandler;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (!this.isEnabled()) {
            sender.sendMessage("This plugin is Disabled!");
            return true;
        }
        ArrayList<String> allArgs = new ArrayList<String>(Arrays.asList(args));
        allArgs.add(0, command.getName());
        return this.commandHandler.locateAndRunCommand(sender, allArgs);
    }

    public Configuration getConfig() {
        return this.config;
    }

    public void setFix(boolean fix) {
        this.fix = fix;
    }

    public boolean isFixed() {
        return this.fix;
    }
}
