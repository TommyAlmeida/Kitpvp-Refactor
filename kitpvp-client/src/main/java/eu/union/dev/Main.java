package eu.union.dev;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

    }

    private void registerListeners(Listener... listeners){
        PluginManager pm = Bukkit.getPluginManager();

        for(Listener l : listeners){
            pm.registerEvents(l, this);
        }
    }
}
