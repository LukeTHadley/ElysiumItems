package com.github.lukethadley.elysiumtools;

import com.github.lukethadley.elysiumtools.listeners.armor.BunnyBootsListener;
import com.github.lukethadley.elysiumtools.listeners.armor.MinersHelmetListener;
import com.github.lukethadley.elysiumtools.listeners.armor.VoyagerSetListener;
import com.github.lukethadley.elysiumtools.listeners.tools.*;
import org.bukkit.plugin.java.JavaPlugin;


public final class ElysiumTools extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Starting Elysium Items");
        getCommand("elysiumtools").setExecutor(new ToolsCommandHandler(this));

        getServer().getPluginManager().registerEvents(new EssentialsFixListener(), this);

        getServer().getPluginManager().registerEvents(new EnderBowListener(), this);
        getServer().getPluginManager().registerEvents(new ShotgunBowListener(this), this);
        getServer().getPluginManager().registerEvents(new DemonicSwordListener(this), this);
        getServer().getPluginManager().registerEvents(new VolatileToolListener(), this);
        getServer().getPluginManager().registerEvents(new LuckOfTheEndListener(), this);
        getServer().getPluginManager().registerEvents(new LuckOfTheNetherListener(), this);
        getServer().getPluginManager().registerEvents(new LuckOfTheOceanListener(), this);

        getServer().getPluginManager().registerEvents(new BunnyBootsListener(), this);
        getServer().getPluginManager().registerEvents(new MinersHelmetListener(), this);
        getServer().getPluginManager().registerEvents(new VoyagerSetListener(), this);

        getLogger().info("Finished Loading Elysium Items");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Disabling Elysium Items");
    }


}
