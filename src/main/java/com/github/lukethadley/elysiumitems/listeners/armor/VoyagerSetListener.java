package com.github.lukethadley.elysiumitems.listeners.armor;

import com.github.lukethadley.elysiumitems.items.armor.boots.VoyagerBoots;
import com.github.lukethadley.elysiumitems.items.armor.chestplate.VoyagerChestplate;
import com.github.lukethadley.elysiumitems.items.armor.helmets.VoyagerHelmet;
import com.github.lukethadley.elysiumitems.items.armor.leggings.VoyagerLeggings;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
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

        if (helmet != null && chestplate != null && leggings != null && boots != null && helmet.getType() != Material.AIR && chestplate.getType() != Material.AIR && leggings.getType() != Material.AIR && boots.getType() != Material.AIR) { // Check items are not null
            NBTItem helmetnbti = new NBTItem(helmet);
            NBTItem chestplatenbti = new NBTItem(chestplate);
            NBTItem leggingsnbti = new NBTItem(leggings);
            NBTItem bootsnbti = new NBTItem(boots);
            if (helmetnbti.getString("plugin").equals("Elysium-Items") && chestplatenbti.getString("plugin").equals("Elysium-Items") && leggingsnbti.getString("plugin").equals("Elysium-Items") && bootsnbti.getString("plugin").equals("Elysium-Items")) { //Check its got the plugin tag
                if (helmetnbti.getString("item").equals(voyagerHelmet.getName()) && chestplatenbti.getString("item").equals(voyagerChestplate.getName()) && leggingsnbti.getString("item").equals(voyagerLeggings.getName()) && bootsnbti.getString("item").equals(voyagerBoots.getName())) { //Check its got the plugin tag
                    player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 1));
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
                    if (helmetnbti.getString("item").equals(voyagerHelmet.getName()) && chestplatenbti.getString("item").equals(voyagerChestplate.getName()) && leggingsnbti.getString("item").equals(voyagerLeggings.getName()) && bootsnbti.getString("item").equals(voyagerBoots.getName())) { //Check its got the plugin tag
                        player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                    }
                }
            }
        }
    }

}
