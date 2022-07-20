package com.github.lukethadley.elysiumitems.listeners.tools;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.HashMap;

public class BlockBreakEventListener implements Listener {

    @EventHandler
    public void blockBreakEventHandler(BlockBreakEvent event){

        if (event.getPlayer().getInventory().getItemInMainHand().getType().isAir()){
            return;
        }

        final NBTItem nbti = new NBTItem(event.getPlayer().getInventory().getItemInMainHand());
        if (nbti.getString("plugin").equals("Elysium-Items")) { // Check it's one of the custom bow's
            final String item = nbti.getString("item");
            final Block blockMaterial = event.getBlock();

            if (item.equals("MagnetPickaxe")) { // Logic to handle MagnetPickaxe
                Collection<ItemStack> items = blockMaterial.getDrops(); //Get all the drops that we want to try to place in the players inv...
                for (ItemStack object : items){ // Iterate over all of the drops...
                    HashMap<Integer, ItemStack> overflowItem = event.getPlayer().getInventory().addItem(object); // Method attempts to place it in the inventory, if it can't, it will return a hashmap of items
                    if (overflowItem.size() == 0){ // If that hashmap contains items, let the event handle the dropping naturally
                        event.setDropItems(false);  // If it does not contain anything, tell the event not to drop items
                    }
                }
            }

            else if (item.equals("FurnaceShovel")){ //Logic to handle Furnace Shovel
                if (blockMaterial.getType() == Material.SAND){
                    event.setDropItems(false);
                    event.getPlayer().getWorld().dropItemNaturally(blockMaterial.getLocation(), new ItemStack(Material.GLASS, blockMaterial.getDrops().size()));
                }
            }

            else if (item.equals("CruciblePickaxe")){ //Logic to handle Crucible Pickaxe
                if (blockMaterial.getType() == Material.IRON_ORE || blockMaterial.getType() == Material.DEEPSLATE_IRON_ORE){
                    event.setDropItems(false);
                    event.getPlayer().getWorld().dropItemNaturally(blockMaterial.getLocation(), new ItemStack(Material.IRON_INGOT, blockMaterial.getDrops().size()));
                }
                else if (blockMaterial.getType() == Material.COPPER_ORE || blockMaterial.getType() == Material.DEEPSLATE_COPPER_ORE){
                    event.setDropItems(false);
                    event.getPlayer().getWorld().dropItemNaturally(blockMaterial.getLocation(), new ItemStack(Material.COPPER_INGOT, blockMaterial.getDrops().size()));
                }
                else if (blockMaterial.getType() == Material.GOLD_ORE || blockMaterial.getType() == Material.DEEPSLATE_GOLD_ORE){
                    event.setDropItems(false);
                    event.getPlayer().getWorld().dropItemNaturally(blockMaterial.getLocation(), new ItemStack(Material.GOLD_INGOT, blockMaterial.getDrops().size()));
                }
            }

        }

    }

}
