package com.github.lukethadley.elysiumitems.listeners.armor;

import com.github.lukethadley.elysiumitems.items.armor.boots.BunnyBoots;
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

public class BunnyBootsListener implements Listener {

    private BunnyBoots bunnyBoots;

    public BunnyBootsListener(){
        bunnyBoots = new BunnyBoots();
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        ItemStack cursor = event.getCursor();

        if (event.getSlotType().equals(InventoryType.SlotType.ARMOR)) {
            if (cursor != null && cursor.getType() == bunnyBoots.getItemType()) { //Applying
                if (cursor.hasItemMeta() && cursor.getItemMeta().hasLore()) {
                    List<String> lore = cursor.getItemMeta().getLore();
                    if (lore.equals(bunnyBoots.getLoreAsListString())) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 2));
                        return;
                    }
                }
            }
            else if (item != null && item.getType() == bunnyBoots.getItemType()) { //Removing
                if (item.hasItemMeta() && item.getItemMeta().hasLore()) {
                    List<String> lore = item.getItemMeta().getLore();
                    if (lore.equals(bunnyBoots.getLoreAsListString())) {
                        player.removePotionEffect(PotionEffectType.JUMP);
                        return;
                    }
                }
            }

        }
    }

    @EventHandler
    public void inventoryClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        ItemStack boots = player.getInventory().getBoots();
        if (boots != null && boots.getItemMeta().hasLore()){
            if (boots.getItemMeta().getLore().equals(bunnyBoots.getLoreAsListString())){
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 2));
                return;
            }
        }
    }

}
