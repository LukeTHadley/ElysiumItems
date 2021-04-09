/*
https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerItemBreakEvent.html
 */


package com.github.lukethadley.elysiumtools.listeners;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VolatileToolListener implements Listener {

    private static final List<String> VOLATILE_FIREWORK_LORE_TAG = Arrays.asList(new String[]{"volatileToolExplosion"}.clone());
    private static final List<Color> COLOR_LIST = Arrays.asList(Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW);

    public static Random rand;

    public VolatileToolListener(){
        rand = new Random();
    }

    //Run the firework on item breaking
    @EventHandler
    public void volatileToolExplosion(PlayerItemBreakEvent e){
        Location loc = e.getPlayer().getLocation();
        loc.setY(loc.getY()+1);

        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        fwm.addEffect(FireworkEffect.builder().withColor(COLOR_LIST.get(rand.nextInt(COLOR_LIST.size()))).flicker(true).build());
        fwm.addEffect(FireworkEffect.builder().withColor(COLOR_LIST.get(rand.nextInt(COLOR_LIST.size()))).trail(true).build());

        fwm.setLore(VOLATILE_FIREWORK_LORE_TAG);

        fw.setFireworkMeta(fwm);
        fw.detonate();

    }

    //Negate the damage that the firework does, set the health of the player to half a heart
    @EventHandler
    public void negateFireworkDamageForVolatile(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Firework) { //If the entity that did the damage was a firework
            if (e.getEntity() instanceof Player) { //And the entity was damaged was a player
                Firework damager = (Firework) e.getDamager();
                Player damagee = (Player) e.getEntity();
                if (damager.getFireworkMeta().getLore().equals(VOLATILE_FIREWORK_LORE_TAG)){ //If it was a firework from a volatile explosion
                    damagee.setHealth(1.0);
                    e.setCancelled(true);
                }

            }
        }
    }
}
