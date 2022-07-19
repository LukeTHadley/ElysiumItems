package com.github.lukethadley.elysiumitems.listeners.tools;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MagnetPickaxeListener implements Listener {

    @EventHandler
    public void checkCruciblePickaxe(BlockBreakEvent event){

        ItemStack pickaxe = event.getPlayer().getInventory().getItemInMainHand();
        if (pickaxe == null || pickaxe.getType().isAir()){
            return;
        }

        NBTItem nbti = new NBTItem(pickaxe);
        String plugin = nbti.getString("plugin");
        String item = nbti.getString("item");
        if (plugin.equals("Elysium-Items")) {
            if (item.equals("MagnetPickaxe")) {
                Collection<ItemStack> items = event.getBlock().getDrops(); //Get all the drops that we want to try to place in the players inv...
                for (ItemStack object : items){ // Iterate over all of the drops...
                    HashMap<Integer, ItemStack> overflowItem = event.getPlayer().getInventory().addItem(object); // Method attempts to place it in the inventory, if it can't, it will return a hashmap of items
                    if (overflowItem.size() == 0){ // If that hashmap contains items, let the event handle the dropping naturally
                        event.setDropItems(false);  // If it does not contain anything, tell the event not to drop items
                    }
                }
            }
        }
    }

}
