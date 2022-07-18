package com.github.lukethadley.elysiumitems.listeners.tools;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class SpiderScytheListener implements Listener {

    @EventHandler
    public void spiderScytheListener(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Player){
            if (event.getEntity() instanceof Spider){

                Player damager = (Player) event.getDamager();
                ItemStack tool = damager.getInventory().getItemInMainHand();
                if (tool == null || tool.getType().isAir()){
                    return;
                }

                NBTItem nbti = new NBTItem(tool);
                String plugin = nbti.getString("plugin");
                String item = nbti.getString("item");
                if (plugin.equals("Elysium-Items")) {
                    if (item.equals("SpiderScythe")) {
                        Spider spider = (Spider) event.getEntity();
                        event.setDamage(spider.getHealth());

                    }
                }
            }
        }
    }


}
