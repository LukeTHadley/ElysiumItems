package com.github.lukethadley.elysiumitems.listeners.tools;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class MeatCleaverListener implements Listener {

    @EventHandler
    public void meatCleaverListener(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Player){
            if (event.getEntity() instanceof Pig ||
                    event.getEntity() instanceof Chicken ||
                    event.getEntity() instanceof Cow ||
                    event.getEntity() instanceof MushroomCow ||
                    event.getEntity() instanceof Sheep ||
                    event.getEntity() instanceof Rabbit){

                Player damager = (Player) event.getDamager();
                ItemStack tool = damager.getInventory().getItemInMainHand();
                if (tool == null || tool.getType().isAir()){
                    return;
                }

                NBTItem nbti = new NBTItem(tool);
                String plugin = nbti.getString("plugin");
                String item = nbti.getString("item");
                if (plugin.equals("Elysium-Items")) {
                    if (item.equals("MeatCleaver")) {
                        event.setDamage(((Animals) event.getEntity()).getHealth());
                    }
                }
            }
        }
    }

}
