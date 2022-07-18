package com.github.lukethadley.elysiumitems.listeners.armor;

import com.github.lukethadley.elysiumitems.items.armor.leggings.PantsofUnChafing;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PantsOfUnChafingListener implements Listener {


    private PantsofUnChafing pantsofUnChafing;

    public PantsOfUnChafingListener() { pantsofUnChafing = new PantsofUnChafing(); }

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();
        ItemStack cursor = event.getCursor();

        if (event.getSlotType().equals(InventoryType.SlotType.ARMOR)) {
            if (cursor != null && cursor.getType() == pantsofUnChafing.getItemType()) { //Applying
                NBTItem cursornbti = new NBTItem(cursor);
                if (cursornbti.getString("plugin").equals("Elysium-Items") && cursornbti.getString("item").equals("PantsOfUnChafing")){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
                    return;
                }
            }
            else if (item != null && item.getType() == pantsofUnChafing.getItemType()) { //Removing
                NBTItem itemnbti = new NBTItem(item);
                if (itemnbti.getString("plugin").equals("Elysium-Items") && itemnbti.getString("item").equals("PantsOfUnChafing")) {
                    player.removePotionEffect(PotionEffectType.SPEED);
                    return;
                }
            }

        }
    }

    @EventHandler
    public void inventoryClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        ItemStack leggings = player.getInventory().getLeggings();
        if (leggings == null){
            return;
        }
        NBTItem nbti = new NBTItem(leggings);
        String plugin = nbti.getString("plugin");
        String item = nbti.getString("item");
        if (plugin.equals("Elysium-Items")) {
            if (item.equals("PantsOfUnChafing")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
                return;
            }
        }


    }
}
