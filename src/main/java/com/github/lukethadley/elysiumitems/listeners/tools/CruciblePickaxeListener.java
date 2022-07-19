package com.github.lukethadley.elysiumitems.listeners.tools;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class CruciblePickaxeListener implements Listener {


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
            if (item.equals("CruciblePickaxe")) {


                Material blockMaterial = event.getBlock().getType();

                if (blockMaterial == Material.IRON_ORE || blockMaterial == Material.DEEPSLATE_IRON_ORE){
                    event.setDropItems(false);
                    event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT, event.getBlock().getDrops().size()));
                }
                if (blockMaterial == Material.COPPER_ORE || blockMaterial == Material.DEEPSLATE_COPPER_ORE){
                    event.setDropItems(false);
                    event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COPPER_INGOT, event.getBlock().getDrops().size()));
                }
                if (blockMaterial == Material.GOLD_ORE || blockMaterial == Material.DEEPSLATE_GOLD_ORE){
                    event.setDropItems(false);
                    event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT, event.getBlock().getDrops().size()));
                }


            }
        }





    }

}
