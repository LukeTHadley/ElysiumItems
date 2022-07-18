package com.github.lukethadley.elysiumitems.listeners.tools;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

public class CodFatherListener implements Listener {

    @EventHandler
    public void PlayerFishEvent(PlayerFishEvent event) {

        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            ItemStack fishingRod = event.getPlayer().getItemInHand();
            if (fishingRod.getType() != Material.FISHING_ROD){
                return;
            }
            NBTItem nbti = new NBTItem(fishingRod);

            String plugin = nbti.getString("plugin");
            String item = nbti.getString("item");
            if (plugin.equals("Elysium-Items")) {
                if (item.equals("CodFatherRod")) {
                    Item stack = (Item) event.getCaught();
                    if (stack.getItemStack().getType() == Material.COD){
                        stack.setItemStack(new ItemStack(Material.COOKED_COD)); //Your new itemstack here!
                    }
                    if (stack.getItemStack().getType() == Material.SALMON) {
                        stack.setItemStack(new ItemStack(Material.COOKED_SALMON)); //Your new itemstack here!
                    }

                }

            }
        }
    }

}
