package com.github.lukethadley.elysiumitems.listeners.tools;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class FurnaceShovelListener implements Listener {

    @EventHandler
    public void checkCruciblePickaxe(BlockBreakEvent event){
        ItemStack pickaxe = event.getPlayer().getInventory().getItemInMainHand();
        NBTItem nbti = new NBTItem(pickaxe);
        String plugin = nbti.getString("plugin");
        String item = nbti.getString("item");
        if (plugin.equals("Elysium-Items")) {
            if (item.equals("FurnaceShovel")) {
                if (event.getBlock().getType() == Material.SAND){
                    event.setDropItems(false);
                    event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.GLASS, event.getBlock().getDrops().size()));
                }
            }
        }


    }

}
