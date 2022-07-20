package com.github.lukethadley.elysiumitems.listeners;

import com.github.lukethadley.elysiumitems.ElysiumItems;
import com.github.lukethadley.elysiumitems.ToolsMessages;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.UUID;

public class EntityShootBowEventListener implements Listener {

    private final ElysiumItems plugin;
    private final ArrayList<UUID> cooldowns;

    private static final double UPPER_BOUND = 0.3;
    private static final double LOWER_BOUND = 0.0;


    public EntityShootBowEventListener(ElysiumItems plugin){
        this.plugin = plugin;
        cooldowns = new ArrayList<>();
    }


    @EventHandler
    public void entityShowBowEventHandler(EntityShootBowEvent e){

        if (e.getEntity() instanceof Player){ // Check that the entity shooting the bow is a Player


            if (e.getBow() == null || e.getBow().getType().isAir()){ // If the bow is null or Air for some reason (NBT-API doesn't like operating on air)
                return; // This shouldn't happen tho given the event is only called when an entity shoots a bow...
            }

            final NBTItem nbti = new NBTItem(e.getBow());
            if (nbti.getString("plugin").equals("Elysium-Items")) { // Check it's one of the custom bow's
                final String item = nbti.getString("item");
                final Player player = (Player) e.getEntity();
                // Check if the custom bow is one of the following
                if (item.equals("ShotgunBow")) { // Shotgun Bow Logic

                    if (!shotgunBowCooldown(player)) {
                        if (player.getGameMode() != GameMode.CREATIVE) { //If the player is in creative then we can let them fire the bow regardless

                            if (!player.getInventory().contains(Material.ARROW, 5)) { //Check if the player's inventory doesn't contain 5 arrows
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.SHOTGUN_BOW_NOT_ENOUGH_ARROWS)); //Send them a message
                                e.setConsumeItem(false);
                                e.setCancelled(true); //Cancel the event so an arrow isn't shot
                                return;
                            } else {
                                ItemStack arrows = new ItemStack(Material.ARROW, 5); //Create an ItemStack of 1 ender pearl
                                player.getInventory().removeItem(arrows); //Use the created ItemStack to remove 1 ender pearl from the player's inventory
                            }
                        }


                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.SHOTGUN_BOW_USE_MESSAGE));


                        Entity arrow = e.getProjectile();
                        Vector velocity = arrow.getVelocity();


                        Vector v1 = new Vector(velocity.getX(), velocity.getY(), velocity.getZ());

                        Vector v2 = new Vector(velocity.getX(), velocity.getY() - (Math.random() * (LOWER_BOUND - UPPER_BOUND)) + UPPER_BOUND, velocity.getZ() - (Math.random() * (LOWER_BOUND - UPPER_BOUND)) + UPPER_BOUND);
                        Vector v3 = new Vector(velocity.getX(), velocity.getY() + (Math.random() * (LOWER_BOUND - UPPER_BOUND)) + UPPER_BOUND, velocity.getZ() + (Math.random() * (LOWER_BOUND - UPPER_BOUND)) + UPPER_BOUND);
                        Vector v4 = new Vector(velocity.getX() - (Math.random() * (LOWER_BOUND - UPPER_BOUND)) + UPPER_BOUND, velocity.getY(), velocity.getZ());
                        Vector v5 = new Vector(velocity.getX() + (Math.random() * (LOWER_BOUND - UPPER_BOUND)) + UPPER_BOUND, velocity.getY(), velocity.getZ());

                        Arrow arrow1 = player.launchProjectile(Arrow.class, v1);
                        arrow1.setShooter(player);

                        Arrow arrow2 = player.launchProjectile(Arrow.class, v2);
                        arrow2.setShooter(player);

                        Arrow arrow3 = player.launchProjectile(Arrow.class, v3);
                        arrow3.setShooter(player);

                        Arrow arrow4 = player.launchProjectile(Arrow.class, v4);
                        arrow4.setShooter(player);

                        Arrow arrow5 = player.launchProjectile(Arrow.class, v5);
                        arrow5.setShooter(player);


                        arrow.remove();
                        return;


                    }
                    e.setCancelled(true);
                }

                else if (item.equals("EnderBow")) { // Ender Bow Logic

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

                else if (item.equals("LightningBow")) { // Lightning Bow Logic
                    e.getProjectile().setCustomName("LightningBowArrow"); //Set a custom name for the arrow (ONLY WHILE IT IS IN FLIGHT!!!) I LOVE THIS FEATURE
                }

            }
        }
    }



    private boolean shotgunBowCooldown(Player player){
        if (!cooldowns.contains(player.getUniqueId())){ //If it doesnt containt the key, we need to put the player on cooldown
            plugin.getLogger().info(player.getName() + " has been put on Shotgun Bow cooldown.");
            cooldowns.add(player.getUniqueId());
            BukkitScheduler scheduler = plugin.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    plugin.getLogger().info(player.getName() + " has been taken off of Shotgun Bow cooldown.");
                    cooldowns.remove(player.getUniqueId());
                }
            }, 120L);

            return false; //But they can do it
        }
        return true;
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
