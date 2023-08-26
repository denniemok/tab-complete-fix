package com.battleasya;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class TabCompleteFix extends JavaPlugin implements Listener {

    public boolean enable = true;

    @Override
    public void onEnable() {

        /* register event handler */
        getServer().getPluginManager().registerEvents(new EventHandler(this), this);

        /* register command executor */
        getCommand("tcftoggle").setExecutor(new CmdExecutor(this));

    }

    public boolean getStatus() {
        return enable;
    }

    public void setEnable() {
        enable = true;
    }

    public void setDisable() {
        enable = false;
    }

}
