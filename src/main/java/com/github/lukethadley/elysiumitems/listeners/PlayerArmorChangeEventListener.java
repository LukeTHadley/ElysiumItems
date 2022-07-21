package com.github.lukethadley.elysiumitems.listeners;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerArmorChangeEventListener implements Listener {

    @EventHandler
    public void playerArmorChangeEventHandler(PlayerArmorChangeEvent event){

        // The following if statement prevents effects from being cleared when a Player is damaged.
        //  This event is called each time a players armor piece changes, this includes if it takes damage...
        //  E.g. Player gets damaged then item piece is replaced by a 'new' piece that has slightly less durability.
        if (event.getNewItem() != null && event.getNewItem().getType() != Material.AIR && event.getOldItem() != null && event.getOldItem().getType() != Material.AIR) {
            if (event.getNewItem().getItemMeta().getDisplayName().equals(event.getOldItem().getItemMeta().getDisplayName())) {
                return;
            }
        }

        // Look at applying new effects
        if (event.getNewItem() != null && event.getNewItem().getType() != Material.AIR){
            final NBTItem nbti = new NBTItem(event.getNewItem());
            if (nbti.getString("plugin").equals("Elysium-Items")) {
                final String item = nbti.getString("item");

                // Logic for Miners Helmet Effect application
                if (item.equals("MinersHelmet")) {
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 0));
                }

                // Logic for Bunny Boots Effect application
                else if (item.equals("BunnyBoots")) {
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 2));
                }

                // Logic for Pants of Unchafing Effect application
                else if (item.equals("PantsOfUnChafing")) {
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
                }

                // Logic for Night Owl Effect application
                else if (item.equals("NightOwlHelmet")) {
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
                }

                // Logic for Voyager Set Effect application
                else if (item.equals("Voyager")) {
                    if (isPlayerWearingFullSet(event.getPlayer().getInventory(), "Voyager")){
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 1));
                    }
                }

                // Logic for Inferno Set Effect application
                else if (item.equals("Inferno")) {
                    if (isPlayerWearingFullSet(event.getPlayer().getInventory(), "Inferno")){
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
                    }
                }

            }
        }

        // Look at removing an old effect
        if (event.getOldItem() != null && event.getOldItem().getType() != Material.AIR){
            final NBTItem nbti = new NBTItem(event.getOldItem());
            if (nbti.getString("plugin").equals("Elysium-Items")) {
                final String item = nbti.getString("item");

                // Logic for Miners Helmet Effect removal
                if (item.equals("MinersHelmet")) {
                    event.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);
                }

                // Logic for Miners Helmet Effect removal
                else if (item.equals("BunnyBoots")) {
                    event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                }

                // Logic for Pants of Unchafing Effect removal
                else if (item.equals("PantsOfUnChafing")) {
                    event.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                }

                // Logic for Night Owl Effect removal
                else if (item.equals("NightOwlHelmet")) {
                    event.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
                }

                // Logic for Voyager Set Effect removal
                else if (item.equals("Voyager")) {
                    event.getPlayer().removePotionEffect(PotionEffectType.HEALTH_BOOST);
                }

                // Logic for Inferno Set Effect removal
                else if (item.equals("Inferno")) {
                    event.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                }

            }
        }

    }


    /**
     * Method to check if a player is wearing a full set of armor by
     *  checking the NBT tags of all armor pieces in the given PlayerInventory,
     *  has an 'item' string with the given 'customSetTag'
     * @param playerInventory - The Player's inventory to check
     * @param customSetTag - The NBT 'item' tag to look for
     * @return - true if the player is wearing a full item set, false if otherwise
     */
    private boolean isPlayerWearingFullSet(PlayerInventory playerInventory, String customSetTag){
        // If the player's armor slots are all occupied by an item...
        if (playerInventory.getHelmet() != null && playerInventory.getChestplate() != null && playerInventory.getLeggings() != null && playerInventory.getBoots() != null &&
                playerInventory.getHelmet().getType() != Material.AIR && playerInventory.getChestplate().getType() != Material.AIR && playerInventory.getLeggings().getType() != Material.AIR && playerInventory.getBoots().getType() != Material.AIR) {
            final NBTItem helmetnbti = new NBTItem(playerInventory.getHelmet());
            final NBTItem chestplatenbti = new NBTItem(playerInventory.getChestplate());
            final NBTItem leggingsnbti = new NBTItem(playerInventory.getLeggings());
            final NBTItem bootsnbti = new NBTItem(playerInventory.getBoots());
            return helmetnbti.getString("item").equals(customSetTag) && chestplatenbti.getString("item").equals(customSetTag) && leggingsnbti.getString("item").equals(customSetTag) && bootsnbti.getString("item").equals(customSetTag);
        }
        return false;
    }


}
