package com.github.lukethadley.elysiumitems.listeners.armor;

import com.github.lukethadley.elysiumitems.items.armor.boots.ScooberBoots;
import com.github.lukethadley.elysiumitems.items.armor.chestplate.ScooberChestplate;
import com.github.lukethadley.elysiumitems.items.armor.helmets.ScooberHelmet;
import com.github.lukethadley.elysiumitems.items.armor.leggings.ScooberLeggings;
import de.tr7zw.changeme.nbtapi.NBTItem;
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


                if (helmet != null && chestplate != null && leggings != null && boots != null && helmet.getType() != Material.AIR && chestplate.getType() != Material.AIR && leggings.getType() != Material.AIR && boots.getType() != Material.AIR) { // Check items are not null
                    NBTItem helmetnbti = new NBTItem(helmet);
                    NBTItem chestplatenbti = new NBTItem(chestplate);
                    NBTItem leggingsnbti = new NBTItem(leggings);
                    NBTItem bootsnbti = new NBTItem(boots);
                    if (helmetnbti.getString("plugin").equals("Elysium-Items") && chestplatenbti.getString("plugin").equals("Elysium-Items") && leggingsnbti.getString("plugin").equals("Elysium-Items") && bootsnbti.getString("plugin").equals("Elysium-Items")) { //Check its got the plugin tag
                        if (helmetnbti.getString("item").equals(scooberHelmet.getName()) && chestplatenbti.getString("item").equals(scooberChestplate.getName()) && leggingsnbti.getString("item").equals(scooberLeggings.getName()) && bootsnbti.getString("item").equals(scooberBoots.getName())) { //Check its got the plugin tag
                            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
                            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1));
                            currentPlayers.add(e.getPlayer().getUniqueId());
                            return;
                        }
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

        Player player = (Player) e.getWhoClicked(); //Get the player
        ItemStack item = e.getCurrentItem(); //And the item in their hand
        if (item != null){ //If there is an item in their hand
            ItemStack helmet = player.getInventory().getHelmet();
            ItemStack chestplate = player.getInventory().getChestplate();
            ItemStack leggings = player.getInventory().getLeggings();
            ItemStack boots = player.getInventory().getBoots();
            if (helmet != null && chestplate != null && leggings != null && boots != null && helmet.getType() != Material.AIR && chestplate.getType() != Material.AIR && leggings.getType() != Material.AIR && boots.getType() != Material.AIR) { // Check items are not null
                NBTItem helmetnbti = new NBTItem(helmet);
                NBTItem chestplatenbti = new NBTItem(chestplate);
                NBTItem leggingsnbti = new NBTItem(leggings);
                NBTItem bootsnbti = new NBTItem(boots);
                if (helmetnbti.getString("plugin").equals("Elysium-Items") && chestplatenbti.getString("plugin").equals("Elysium-Items") && leggingsnbti.getString("plugin").equals("Elysium-Items") && bootsnbti.getString("plugin").equals("Elysium-Items")) { //Check its got the plugin tag
                    if (helmetnbti.getString("item").equals(scooberHelmet.getName()) && chestplatenbti.getString("item").equals(scooberChestplate.getName()) && leggingsnbti.getString("item").equals(scooberLeggings.getName()) && bootsnbti.getString("item").equals(scooberBoots.getName())) { //Check its got the plugin tag
                        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                        player.removePotionEffect(PotionEffectType.WATER_BREATHING);
                        currentPlayers.remove(player.getUniqueId());
                        return;
                    }
                }
            }
        }
   }

}
