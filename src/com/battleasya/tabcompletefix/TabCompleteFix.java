package com.battleasya.tabcompletefix;

import com.battleasya.tabcompletefix.command.Toggle;
import com.battleasya.tabcompletefix.handler.TabComplete;
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
