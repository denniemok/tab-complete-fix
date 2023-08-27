package com.battleasya;

import org.bukkit.plugin.java.JavaPlugin;

public class TabCompleteFix extends JavaPlugin {

    public boolean enable = true;

    @Override
    public void onEnable() {

        /* register event handler */
        getServer().getPluginManager().registerEvents(new TCFEventHandler(this), this);

        /* register command executor */
        getCommand("tcftoggle").setExecutor(new TCFCmdExecutor(this));

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
