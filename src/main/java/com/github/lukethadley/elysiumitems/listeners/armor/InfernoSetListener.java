package com.github.lukethadley.elysiumitems.listeners.armor;

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
import java.util.UUID;

public class InfernoSetListener implements Listener {

    private ArrayList<UUID> currentPlayers;

    public InfernoSetListener(){
        currentPlayers = new ArrayList<>();
    }

    @EventHandler
    public void applyPotion(InventoryCloseEvent e){
        Player player = (Player) e.getPlayer();
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
                if (helmetnbti.getString("item").equals("Inferno") && chestplatenbti.getString("item").equals("Inferno") && leggingsnbti.getString("item").equals("Inferno") && bootsnbti.getString("item").equals("Inferno")) { //Check its got the plugin tag
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
                }
            }
        }
    }

    @EventHandler
    public void removePotion(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked(); //Get the player
        ItemStack item = e.getCurrentItem(); //And the item in their hand
        if (item != null) { //If there is an item in their hand
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
                    if (helmetnbti.getString("item").equals("Inferno") && chestplatenbti.getString("item").equals("Inferno") && leggingsnbti.getString("item").equals("Inferno") && bootsnbti.getString("item").equals("Inferno")) { //Check its got the plugin tag
                        player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                    }
                }
            }
        }
    }






    /**
    @EventHandler
    public void waterListener(PlayerMoveEvent e){
        if (e.getPlayer().getLocation().getBlock().getType() == Material.LAVA) { //In water
            if (!currentPlayers.contains(e.getPlayer().getUniqueId())){ //Add Potion Effect
                Player player = e.getPlayer();
                ItemStack helmet = player.getInventory().getHelmet();
                ItemStack chestplate = player.getInventory().getChestplate();
                ItemStack leggings = player.getInventory().getLeggings();
                ItemStack boots = player.getInventory().getBoots();


                if (helmet != null && chestplate != null && leggings != null && boots != null) { // Check items are not null
                    NBTItem helmetnbti = new NBTItem(helmet);
                    NBTItem chestplatenbti = new NBTItem(chestplate);
                    NBTItem leggingsnbti = new NBTItem(leggings);
                    NBTItem bootsnbti = new NBTItem(boots);
                    if (helmetnbti.getString("plugin").equals("Elysium-Items") && chestplatenbti.getString("plugin").equals("Elysium-Items") && leggingsnbti.getString("plugin").equals("Elysium-Items") && bootsnbti.getString("plugin").equals("Elysium-Items")) { //Check its got the plugin tag
                        if (helmetnbti.getString("item").equals("Inferno") && chestplatenbti.getString("item").equals("Inferno") && leggingsnbti.getString("item").equals("Inferno") && bootsnbti.getString("item").equals("Inferno")) { //Check its got the plugin tag
                            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
                            currentPlayers.add(e.getPlayer().getUniqueId());
                            return;
                        }
                    }
                }
            }
        }
        else { //Not in water
            if (currentPlayers.contains(e.getPlayer().getUniqueId())){ //Remove Potion Effect
                e.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
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
            if (helmet != null && chestplate != null && leggings != null && boots != null) { // Check items are not null
                NBTItem helmetnbti = new NBTItem(helmet);
                NBTItem chestplatenbti = new NBTItem(chestplate);
                NBTItem leggingsnbti = new NBTItem(leggings);
                NBTItem bootsnbti = new NBTItem(boots);
                if (helmetnbti.getString("plugin").equals("Elysium-Items") && chestplatenbti.getString("plugin").equals("Elysium-Items") && leggingsnbti.getString("plugin").equals("Elysium-Items") && bootsnbti.getString("plugin").equals("Elysium-Items")) { //Check its got the plugin tag
                    if (helmetnbti.getString("item").equals("Inferno") && chestplatenbti.getString("item").equals("Inferno") && leggingsnbti.getString("item").equals("Inferno") && bootsnbti.getString("item").equals("Inferno")) { //Check its got the plugin tag
                        player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                        currentPlayers.remove(player.getUniqueId());
                        return;
                    }
                }
            }
        }
    }
    **/

}

