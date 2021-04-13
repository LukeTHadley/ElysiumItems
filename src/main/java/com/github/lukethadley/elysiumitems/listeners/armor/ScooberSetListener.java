package com.github.lukethadley.elysiumitems.listeners.armor;

import com.github.lukethadley.elysiumitems.items.armor.boots.ScooberBoots;
import com.github.lukethadley.elysiumitems.items.armor.chestplate.ScooberChestplate;
import com.github.lukethadley.elysiumitems.items.armor.helmets.ScooberHelmet;
import com.github.lukethadley.elysiumitems.items.armor.leggings.ScooberLeggings;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ScooberSetListener implements Listener {

    private ScooberBoots scooberBoots;
    private ScooberLeggings scooberLeggings;
    private ScooberChestplate scooberChestplate;
    private ScooberHelmet scooberHelmet;

    private ArrayList<UUID> currentPlayers;

    public ScooberSetListener(){
        currentPlayers = new ArrayList<>();
        scooberBoots = new ScooberBoots();
        scooberLeggings = new ScooberLeggings();
        scooberChestplate = new ScooberChestplate();
        scooberHelmet = new ScooberHelmet();
    }

    @EventHandler
    public void waterListener(PlayerMoveEvent e){
        if (e.getPlayer().getLocation().getBlock().getType() == Material.WATER) { //In water
            if (!currentPlayers.contains(e.getPlayer().getUniqueId())){ //Add Potion Effect
                Player player = e.getPlayer();
                ItemStack helmet = player.getInventory().getHelmet();
                ItemStack chestplate = player.getInventory().getChestplate();
                ItemStack leggings = player.getInventory().getLeggings();
                ItemStack boots = player.getInventory().getBoots();
                if (helmet != null && helmet.getItemMeta().hasLore() && chestplate != null && chestplate.getItemMeta().hasLore() && leggings != null && leggings.getItemMeta().hasLore() && boots != null && boots.getItemMeta().hasLore()){
                    if (helmet.getItemMeta().getLore().equals(scooberHelmet.getLoreAsListString()) && chestplate.getItemMeta().getLore().equals(scooberChestplate.getLoreAsListString()) && leggings.getItemMeta().getLore().equals(scooberLeggings.getLoreAsListString()) && boots.getItemMeta().getLore().equals(scooberBoots.getLoreAsListString())){
                        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
                        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1));
                        currentPlayers.add(e.getPlayer().getUniqueId());
                        return;
                    }
                }
            }
        }
        else { //Not in water
            if (currentPlayers.contains(e.getPlayer().getUniqueId())){ //Remove Potion Effect
                e.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
                e.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);
                currentPlayers.remove(e.getPlayer().getUniqueId());
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
                    if (item.getType() == scooberHelmet.getItemType() || item.getType() == scooberChestplate.getItemType() || item.getType() == scooberLeggings.getItemType() || item.getType() == scooberBoots.getItemType()) {
                        if (lore.equals(scooberHelmet.getLoreAsListString()) || lore.equals(scooberChestplate.getLoreAsListString()) || lore.equals(scooberLeggings.getLoreAsListString()) || lore.equals(scooberBoots.getLoreAsListString())) {
                            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                            player.removePotionEffect(PotionEffectType.WATER_BREATHING);
                            currentPlayers.remove(player.getUniqueId());
                        }
                    }
                }
            }
        } catch (NullPointerException ignored){ } // 'item.getItemMeta().hasLore()' has the possibility of returning a null that is hard to parry with an if statement. Try/Catch needed :(
    }

}
