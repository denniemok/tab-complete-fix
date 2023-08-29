package com.battleasya.Cmd;

import com.battleasya.TabCompleteFix;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TCFToggle implements CommandExecutor {

    private final TabCompleteFix plugin;

    public TCFToggle(TabCompleteFix plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        /* if sender has the correct permission */
        if (sender.hasPermission("tcf.admin")) {
            if (plugin.getStatus()) {
                plugin.setDisable();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&4&l!&8) &cTabCompleteFix Disabled."));
            } else {
                plugin.setEnable();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&4&l!&8) &aTabCompleteFix Enabled."));
            }
        }

        return true;

    }

}
