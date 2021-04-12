package com.github.lukethadley.elysiumtools.listeners.armor;

import com.github.lukethadley.elysiumtools.items.armor.boots.VoyagerBoots;
import com.github.lukethadley.elysiumtools.items.armor.chestplate.VoyagerChestplate;
import com.github.lukethadley.elysiumtools.items.armor.helmets.VoyagerHelmet;
import com.github.lukethadley.elysiumtools.items.armor.leggings.VoyagerLeggings;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class VoyagerSetListener implements Listener {

    private VoyagerHelmet voyagerHelmet;
    private VoyagerChestplate voyagerChestplate;
    private VoyagerLeggings voyagerLeggings;
    private VoyagerBoots voyagerBoots;

    public VoyagerSetListener(){
        voyagerHelmet = new VoyagerHelmet();
        voyagerChestplate = new VoyagerChestplate();
        voyagerLeggings = new VoyagerLeggings();
        voyagerBoots = new VoyagerBoots();
    }

    @EventHandler
    public void applyPotion(InventoryCloseEvent e){
        Player player = (Player) e.getPlayer();
        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();
        if (helmet != null && helmet.getItemMeta().hasLore() && chestplate != null && chestplate.getItemMeta().hasLore() && leggings != null && leggings.getItemMeta().hasLore() && boots != null && boots.getItemMeta().hasLore()){
            if (helmet.getItemMeta().getLore().equals(voyagerHelmet.getLoreAsListString()) && chestplate.getItemMeta().getLore().equals(voyagerChestplate.getLoreAsListString()) && leggings.getItemMeta().getLore().equals(voyagerLeggings.getLoreAsListString()) && boots.getItemMeta().getLore().equals(voyagerBoots.getLoreAsListString())){
                player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 1));
                return;
            }
        }
    }

    @EventHandler
    public void removePotion(InventoryClickEvent e){
        try {
            Player player = (Player) e.getWhoClicked(); //Get the player
            ItemStack item = e.getCurrentItem(); //And the item in their hand
            if (item != null){ //If there is an item in their hand
                if (item.getItemMeta().hasLore() && item.getItemMeta().getLore() == null){ //And that item does have a lore
                    return;
                }
                List<String> lore = item.getItemMeta().getLore();
                if (lore != null) { //Check the item has a lore again
                    if (item.getType() == voyagerHelmet.getItemType() || item.getType() == voyagerChestplate.getItemType() || item.getType() == voyagerLeggings.getItemType() || item.getType() == voyagerBoots.getItemType()) {
                        if (lore.equals(voyagerHelmet.getLoreAsListString()) || lore.equals(voyagerChestplate.getLoreAsListString()) || lore.equals(voyagerLeggings.getLoreAsListString()) || lore.equals(voyagerBoots.getLoreAsListString())) {
                            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                        }
                    }
                }


            }
        } catch (NullPointerException ignored){ } // 'item.getItemMeta().hasLore()' has the possibility of returning a null that is hard to parry with an if statement. Try/Catch needed :(
    }

}
