package com.github.lukethadley.elysiumtools;

import com.github.lukethadley.elysiumtools.listeners.DemonicSwordListener;
import com.github.lukethadley.elysiumtools.listeners.EnderBowListener;
import com.github.lukethadley.elysiumtools.listeners.ShotgunBowListener;
import com.google.common.collect.ImmutableMap;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import javax.tools.Tool;
import java.util.Map;


public final class ElysiumTools extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Testing elysium  tools startup");
        getCommand("elysiumtools").setExecutor(new ToolsCommandHandler());

        getServer().getPluginManager().registerEvents(new EnderBowListener(), this);
        getServer().getPluginManager().registerEvents(new ShotgunBowListener(this), this);
        getServer().getPluginManager().registerEvents(new DemonicSwordListener(this), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Testing elysium  tools shutdown");
    }


}
