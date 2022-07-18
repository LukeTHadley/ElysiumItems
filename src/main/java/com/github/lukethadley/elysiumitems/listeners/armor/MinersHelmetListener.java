package com.github.lukethadley.elysiumitems.listeners.armor;

import com.github.lukethadley.elysiumitems.items.armor.helmets.MinersHelmet;
import de.tr7zw.changeme.nbtapi.NBTItem;
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
                NBTItem cursornbti = new NBTItem(cursor);
                if (cursornbti.getString("plugin").equals("Elysium-Items") && cursornbti.getString("item").equals("MinersHelmet")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 0));
                    return;
                }


            }
            else if (item != null && item.getType() == minersHelmet.getItemType()) { //Removing
                NBTItem itemnbti = new NBTItem(item);
                if (itemnbti.getString("plugin").equals("Elysium-Items") && itemnbti.getString("item").equals("MinersHelmet")) {
                    player.removePotionEffect(PotionEffectType.FAST_DIGGING);
                    return;
                }
            }

        }
    }

    @EventHandler
    public void inventoryClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        ItemStack helmet = player.getInventory().getHelmet();
        if (helmet == null){
            return;
        }
        NBTItem nbti = new NBTItem(helmet);
        String plugin = nbti.getString("plugin");
        String item = nbti.getString("item");
        if (plugin.equals("Elysium-Items")) {
            if (item.equals("MinersHelmet")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 0));
                return;
            }
        }


    }

}

