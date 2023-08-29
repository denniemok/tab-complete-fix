package com.battleasya;

import com.battleasya.Cmd.Toggle;
import com.battleasya.Hdlr.TabComplete;
import org.bukkit.plugin.java.JavaPlugin;

public class TabCompleteFix extends JavaPlugin {

    public boolean enable = true;

    @Override
    public void onEnable() {

        /* register event handler */
        getServer().getPluginManager().registerEvents(new TabComplete(this), this);

        /* register command executor */
        getCommand("tcftoggle").setExecutor(new Toggle(this));

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
