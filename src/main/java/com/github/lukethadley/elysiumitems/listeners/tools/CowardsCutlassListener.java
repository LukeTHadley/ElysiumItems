package com.github.lukethadley.elysiumitems.listeners.tools;

import com.github.lukethadley.elysiumitems.items.tools.swords.CowardsCutlassSword;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class CowardsCutlassListener implements Listener {

    private CowardsCutlassSword cowardsCutlassSword;

    public CowardsCutlassListener(){
        cowardsCutlassSword = new CowardsCutlassSword();
    }

    @EventHandler
    public void checkHitEvent(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) { //If the entity that was damaged is a player
            if (e.getDamager() instanceof Player) { //And the entity that damaged that player is a player
                Player damager = (Player) e.getDamager();
                Player damagee = (Player) e.getEntity();

                ItemStack tool = damager.getInventory().getItemInMainHand();
                if (tool == null || tool.getItemMeta().getLore() == null) {
                    return;
                }

                if (tool.getItemMeta().getLore().get(0).equals(cowardsCutlassSword.getLoreAsListString().get(0)) && tool.getItemMeta().getLore().get(1).equals(cowardsCutlassSword.getLoreAsListString().get(1))) {

                    ItemMeta itmMeta = tool.getItemMeta();
                    List<String> meta = itmMeta.getLore();
                    String line = meta.get(2);

                    String[] split = line.split("Counter = ");
                    int x = Integer.valueOf(split[1])+1;

                    meta.set(2, ChatColor.GRAY + "Counter = " + net.md_5.bungee.api.ChatColor.of("#009973") + x);

                    itmMeta.setLore(meta);

                    tool.setItemMeta(itmMeta);

                    damager.getInventory().setItemInMainHand(tool);


                }
            }
        }
    }

}
