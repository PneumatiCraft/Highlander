package com.pneumaticraft.highlander;
import com.pneumaticraft.commandhandler.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;
public class Highlander extends JavaPlugin {
    private CommandHandler ch;
    private HPermissions permissions;
    @Override
    public void onEnable() {
        this.ch = new CommandHandler(this, permissions);
    }

    @Override
    public void onDisable() {
    }
}
