package com.battleasya;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import de.myzelyam.api.vanish.VanishAPI;

public class EventHandler implements Listener {

    private final TabCompleteFix plugin;

    public EventHandler(TabCompleteFix plugin) {
        this.plugin = plugin;
    }

    @org.bukkit.event.EventHandler
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
            try {
                String playerName = Bukkit.getPlayer(uuid).getName(); // convert UUID to name
                event.getTabCompletions().remove(playerName); // remove from list
            } catch (Exception e) {
                return; // take no action if UUID resolution failed
            }
        }

    }

}
