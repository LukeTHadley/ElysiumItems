package com.github.lukethadley.elysiumtools;

import com.github.lukethadley.elysiumtools.listeners.tools.*;
import org.bukkit.plugin.java.JavaPlugin;


public final class ElysiumTools extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Testing elysium  tools startup");
        getCommand("elysiumtools").setExecutor(new ToolsCommandHandler());

        getServer().getPluginManager().registerEvents(new EssentialsFixListener(), this);

        getServer().getPluginManager().registerEvents(new EnderBowListener(), this);
        getServer().getPluginManager().registerEvents(new ShotgunBowListener(this), this);
        getServer().getPluginManager().registerEvents(new DemonicSwordListener(this), this);
        getServer().getPluginManager().registerEvents(new VolatileToolListener(), this);
        getServer().getPluginManager().registerEvents(new LuckOfTheEndListener(), this);
        getServer().getPluginManager().registerEvents(new LuckOfTheNetherListener(), this);
        getServer().getPluginManager().registerEvents(new LuckOfTheOceanListener(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Testing elysium  tools shutdown");
    }


}
