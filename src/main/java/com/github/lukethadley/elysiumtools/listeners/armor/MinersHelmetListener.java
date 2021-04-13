package com.github.lukethadley.elysiumtools.listeners.armor;

import com.github.lukethadley.elysiumtools.items.armor.boots.BunnyBoots;
import com.github.lukethadley.elysiumtools.items.armor.helmets.MinersHelmet;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class MinersHelmetListener implements Listener {

    private MinersHelmet minersHelmet;

    public MinersHelmetListener(){
        minersHelmet = new MinersHelmet();
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        ItemStack cursor = event.getCursor();

        if (event.getSlotType().equals(InventoryType.SlotType.ARMOR)) {
            if (cursor != null && cursor.getType() == minersHelmet.getItemType()) { //Applying
                if (cursor.hasItemMeta() && cursor.getItemMeta().hasLore()) {
                    List<String> lore = cursor.getItemMeta().getLore();
                    if (lore.equals(minersHelmet.getLoreAsListString())) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 0));
                        return;
                    }
                }
            }
            else if (item != null && item.getType() == minersHelmet.getItemType()) { //Removing
                if (item.hasItemMeta() && item.getItemMeta().hasLore()) {
                    List<String> lore = item.getItemMeta().getLore();
                    if (lore.equals(minersHelmet.getLoreAsListString())) {
                        player.removePotionEffect(PotionEffectType.FAST_DIGGING);
                        return;
                    }
                }
            }

        }
    }

    @EventHandler
    public void inventoryClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        ItemStack helmet = player.getInventory().getHelmet();
        if (helmet != null && helmet.getItemMeta().hasLore()){
            if (helmet.getItemMeta().getLore().equals(minersHelmet.getLoreAsListString())){
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 0));
                return;
            }
        }
    }

}
