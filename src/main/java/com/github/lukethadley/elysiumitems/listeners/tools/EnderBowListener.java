/*
    Ender Bow Listener Class

    Handles the event when a player shoots an Ender Bow

    Shoots out an Ender Pearl like the player has thrown it.
    Will take a pearl out of the inventory


    @Author Thomas9078
    @Date 8-April-2021

 */

package com.github.lukethadley.elysiumitems.listeners.tools;

import com.github.lukethadley.elysiumitems.ToolsMessages;
import com.github.lukethadley.elysiumitems.items.tools.bows.EnderBow;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class EnderBowListener implements Listener {

    EnderBow enderBow;

    public EnderBowListener(){
        enderBow = new EnderBow();
    }

    @EventHandler
    public void enderBowEvent(EntityShootBowEvent e){
        try{
            if (e.getEntity() instanceof Player){ //Make sure the entity shooting this is a player
                Player player = (Player) e.getEntity();
                List<String> enderBowLore = Arrays.asList(enderBow.getLore());
                if (enderBowLore == null){
                    return;
                }

                if (e.getBow().getItemMeta().getLore().equals(enderBowLore)){ // Ensure that it is the enderbow
                    if(player.getGameMode() != GameMode.CREATIVE){ //If the player is in creative then we can let them fire the bow regardless of whether they have ender pearls
                        if(!player.getInventory().contains(Material.ENDER_PEARL)){ //Check if the player's inventory contains any ender pearls
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.ENDER_BOW_NO_ENDERPEARL_EVENT)); //Send them a message
                            e.setConsumeItem(false);
                            e.setCancelled(true); //Cancel the event so an arrow isn't shot
                            return;
                        }
                        else{
                            ItemStack ender = new ItemStack(Material.ENDER_PEARL, 1); //Create an ItemStack of 1 ender pearl
                            player.getInventory().removeItem(ender); //Use the created ItemStack to remove 1 ender pearl from the player's inventory
                        }
                    }
                    //We want to get the arrow entity so we can use it's velocity for the ender pearl then remove it
                    Entity arrow = e.getProjectile();

                    //Since an EnderPearl is a projectile we can create it easily by specifying it's class object and providing the velocity we want to shoot it at
                    EnderPearl pearl = player.launchProjectile(EnderPearl.class, arrow.getVelocity());

                    //Now that we have spawned the ender pearl we want to remove the arrow
                    arrow.remove();

                    //The final step is the set the shooter to the player so it actually teleports them when it hits the ground
                    pearl.setShooter(player);

                }
            }
        } catch (NullPointerException exception){
            return;
        }
    }

}
