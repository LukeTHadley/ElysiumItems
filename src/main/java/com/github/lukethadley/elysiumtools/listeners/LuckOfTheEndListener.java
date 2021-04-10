package com.github.lukethadley.elysiumtools.listeners;

import com.github.lukethadley.elysiumtools.items.tools.pickaxes.LuckOfTheEndPickaxe;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class LuckOfTheEndListener implements Listener {

    private static final List<Material> MATERIAL_LIST = Arrays.asList(Material.OBSIDIAN);

    private static LuckOfTheEndPickaxe luckOfTheEndPickaxe;

    public LuckOfTheEndListener(){
        luckOfTheEndPickaxe = new LuckOfTheEndPickaxe();
    }

    @EventHandler
    public void luckyEndListener(BlockBreakEvent e){
        if (e.getBlock().getWorld().getEnvironment() == World.Environment.THE_END){ //If the player is in the end
            ItemStack tool = e.getPlayer().getInventory().getItemInMainHand();
            if (tool == null || tool.getItemMeta().getLore() == null){
                return;
            }
            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().equals(luckOfTheEndPickaxe.getLoreAsListString())){
                if (MATERIAL_LIST.contains(e.getBlock().getBlockData().getMaterial())){ // If it is a end block
                    e.getPlayer().sendMessage("Hello there!");

                    ItemStack item = new ItemStack(Material.DIAMOND, 8);
                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), item);
                }
            }


        }
        return;
    }
}
