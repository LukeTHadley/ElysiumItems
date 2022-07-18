package com.github.lukethadley.elysiumitems.listeners;

import com.github.lukethadley.elysiumitems.ToolsMessages;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class WorkbenchListener implements Listener {

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(event.getInventory().getType().equals(InventoryType.ANVIL) || event.getInventory().getType().equals(InventoryType.GRINDSTONE) || event.getInventory().getType().equals(InventoryType.ENCHANTING)){
            if (event.getCurrentItem() != null){
                ItemStack item = event.getCurrentItem();
                if (item.getType() != Material.AIR) {
                    NBTItem itemnbti = new NBTItem(item);
                    if (itemnbti.hasKey("plugin")) {
                        if (itemnbti.getString("plugin").equals("Elysium-Items")) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.PLUGIN_PREFIX + ToolsMessages.CANT_PLACE_IN_WORKSTATION));
                            event.setCancelled(true);
                        }
                    }
                }
            }

            if (event.getCursor() != null){
                ItemStack cursor = event.getCursor();
                if (cursor.getType() != Material.AIR) {
                    NBTItem cursornbti = new NBTItem(cursor);
                    if (cursornbti.hasKey("plugin")) {
                        if (cursornbti.getString("plugin").equals("Elysium-Items")) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.PLUGIN_PREFIX + ToolsMessages.CANT_PLACE_IN_WORKSTATION));
                            event.setCancelled(true);
                        }
                    }
                }
            }
        }

    }

}
