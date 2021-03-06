package com.github.lukethadley.elysiumitems;

import com.github.lukethadley.elysiumitems.listeners.*;
import com.github.lukethadley.elysiumitems.listeners.tools.*;
import org.bukkit.plugin.java.JavaPlugin;


public final class ElysiumItems extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Starting Elysium Items...");
        getCommand("elysiumtools").setExecutor(new ToolsCommandHandler(this));
        getCommand("elysiumarmor").setExecutor(new ArmorCommandHandler(this));

        getLogger().info("Applying Listeners...");
        getServer().getPluginManager().registerEvents(new EntityShootBowEventListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockBreakEventListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageByEntityEventListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerArmorChangeEventListener(), this);

        getServer().getPluginManager().registerEvents(new VolatileToolListener(), this);
        //getServer().getPluginManager().registerEvents(new LuckOfTheEndListener(), this);
        //getServer().getPluginManager().registerEvents(new LuckOfTheNetherListener(), this);
        //getServer().getPluginManager().registerEvents(new LuckOfTheOceanListener(), this);
        getServer().getPluginManager().registerEvents(new CodFatherListener(), this);


        //getServer().getPluginManager().registerEvents(new ScooberSetListener(), this);

        getServer().getPluginManager().registerEvents(new WorkbenchListener(), this);

        getLogger().info("Finished Loading Elysium Items");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Disabling Elysium Items");
    }


}
