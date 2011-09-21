package com.pneumaticraft.highlander;

import com.pneumaticraft.commandhandler.PermissionsInterface;
import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * Multiverse 2
 *
 * @author fernferret
 */
public class HPermissions implements PermissionsInterface{
    public HPermissions(Highlander plugin) {

    }
    @Override
    public boolean hasPermission(CommandSender sender, String node, boolean isOpRequired) {
        if(sender.hasPermission(this.))
        return false;
    }

    @Override
    public boolean hasAnyPermission(CommandSender sender, List<String> allPermissionStrings, boolean opRequired) {
        return false;
    }

    @Override
    public boolean hasAllPermission(CommandSender sender, List<String> allPermissionStrings, boolean opRequired) {
        return false;
    }
}
