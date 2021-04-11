package com.github.lukethadley.elysiumtools.listeners.tools;

import com.github.lukethadley.elysiumtools.ElysiumTools;
import com.github.lukethadley.elysiumtools.ToolsMessages;
import com.github.lukethadley.elysiumtools.items.tools.bows.ShotgunBow;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ShotgunBowListener implements Listener {

    private static final double UPPER_BOUND = 0.3;
    private static final double LOWER_BOUND = 0.0;

    ElysiumTools plugin;
    ArrayList<UUID> cooldowns;

    ShotgunBow shotgunBow;

    public ShotgunBowListener(ElysiumTools plugin){
        this.plugin = plugin;
        cooldowns = new ArrayList<>();
        shotgunBow = new ShotgunBow();
    }

    @EventHandler
    public void shotgunBowEvent(EntityShootBowEvent e){

        if (e.getEntity() instanceof Player){
            Player player = (Player) e.getEntity();
            List<String> shotgunBowLore = Arrays.asList(shotgunBow.getLore());
            if (shotgunBowLore == null){
                return;
            }

            if (e.getBow().getItemMeta().getLore().equals(shotgunBowLore)){// Ensure that it is the shotgun bow


                if (!onCooldown(player)){
                    if(player.getGameMode() != GameMode.CREATIVE){ //If the player is in creative then we can let them fire the bow regardless

                        if(!player.getInventory().contains(Material.ARROW, 5)){ //Check if the player's inventory doesn't contain 5 arrows
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.SHOTGUN_BOW_NOT_ENOUGH_ARROWS)); //Send them a message
                            e.setConsumeItem(false);
                            e.setCancelled(true); //Cancel the event so an arrow isn't shot
                            return;
                        }
                        else{
                            ItemStack arrows = new ItemStack(Material.ARROW, 5); //Create an ItemStack of 1 ender pearl
                            player.getInventory().removeItem(arrows); //Use the created ItemStack to remove 1 ender pearl from the player's inventory
                        }
                    }


                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',ToolsMessages.SHOTGUN_BOW_USE_MESSAGE));


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
            return;
        }
    }

    private boolean onCooldown(Player player){
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

}
