package com.battleasya.command;

import com.battleasya.TabCompleteFix;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Toggle implements CommandExecutor {

    private final TabCompleteFix plugin;

    public Toggle(TabCompleteFix plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        /* if sender has the correct permission */
        if (!sender.hasPermission("tcf.admin")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&4&l!&8) &6Unknown Command."));
        }

        if (plugin.getStatus()) {
            plugin.setDisable();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cTabCompleteFix Disabled."));
        } else {
            plugin.setEnable();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aTabCompleteFix Enabled."));
        }

        return true;

    }

}
