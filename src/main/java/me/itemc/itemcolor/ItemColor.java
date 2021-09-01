package me.itemc.itemcolor;

import me.itemc.itemcolor.commands.ColorItem;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemColor extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginCommand("color").setExecutor(new ColorItem(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
