package com.battleasya.Handler;

import java.util.UUID;

import com.battleasya.TabCompleteFix;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import de.myzelyam.api.vanish.VanishAPI;

public class TabComplete implements Listener {

    private final TabCompleteFix plugin;

    public TabComplete(TabCompleteFix plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTabComplete(PlayerChatTabCompleteEvent event) {

        /* if the fix is disabled */
        if (!plugin.getStatus()) {
            return; // take no action
        }

        /* if someone has the ability to vanish, then most probably
           he or she also has the ability to see invisible players */
        if (event.getPlayer().hasPermission("pv.use")) {
            return; // take no action
        }

        /* remove all invisible players from the tab complete list */
        for (UUID uuid : VanishAPI.getInvisiblePlayers()) {

            String playerName = Bukkit.getPlayer(uuid).getName(); // convert UUID to name
            /* https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Bukkit.html#getPlayer(java.util.UUID) */

            if (playerName != null) { // if resolution succeeds
                event.getTabCompletions().remove(playerName); // remove from list
            }

        }

    }

}
