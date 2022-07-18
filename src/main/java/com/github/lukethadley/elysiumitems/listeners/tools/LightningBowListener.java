/*
    Lightning Bow Listener Class

    Handles the event when a player shoots an Lightning Bow

    Has a 10% chance of summoning lightning at the position
        where the arrow landed.

    @Author Thomas9078
    @Date 28-July-2021

 */

package com.github.lukethadley.elysiumitems.listeners.tools;

import com.github.lukethadley.elysiumitems.items.tools.bows.LightningBow;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;


public class LightningBowListener implements Listener {

    private final LightningBow lightningBow;

    public LightningBowListener(){
        lightningBow = new LightningBow();
    }

    @EventHandler
    public void lightningBowShootEvent(EntityShootBowEvent e){
        try{
            if (e.getEntity() instanceof Player){ //Make sure the entity shooting this is a player
                final ItemStack itmStk = e.getBow();
                final NBTItem nbti = new NBTItem(itmStk);
                final String plugin = nbti.getString("plugin");
                final String item = nbti.getString("item");
                if (plugin.equals("Elysium-Items")) {
                    if (item.equals("LightningBow")) {
                           e.getProjectile().setCustomName("LightningBowArrow"); //Set a custom name for the arrow (ONLY WHILE IT IS IN FLIGHT!!!) I LOVE THIS FEATURE
                    }
                }
            }
        }
        catch (NullPointerException exception){ }
    }

    @EventHandler
    public void lightningBowArrowLandEvent(ProjectileHitEvent e){
        try { //When a projectile is hit
            if (e.getEntity().getType() == EntityType.ARROW){ //Ensure it is an arrow
                if (e.getEntity().getCustomName().equals("LightningBowArrow")){ //Check it has the same custom name
                    if (Math.random() < 0.1) { //Chose a random number, see if it is less than 0.1 (10% chance)
                        e.getHitBlock().getWorld().strikeLightning(e.getHitBlock().getLocation()); //Summon Lightning
                    }
                }
            }
        } catch (NullPointerException exception){ }
    }

}

