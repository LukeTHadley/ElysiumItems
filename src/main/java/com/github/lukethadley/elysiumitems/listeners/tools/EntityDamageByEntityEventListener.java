package com.github.lukethadley.elysiumitems.listeners.tools;

import com.github.lukethadley.elysiumitems.ElysiumItems;
import com.github.lukethadley.elysiumitems.ToolsMessages;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class EntityDamageByEntityEventListener implements Listener {

    private final ElysiumItems plugin;

    private final ArrayList<UUID> demonicSwordCooldownList;

    public EntityDamageByEntityEventListener(ElysiumItems plugin){
        this.plugin = plugin;
        demonicSwordCooldownList = new ArrayList<>();
    }

    @EventHandler
    public void entityDamageByEntityHandler(EntityDamageByEntityEvent event){

        // Start of logic for Volatile Tool Firework Damage Event
        if (event.getDamager() instanceof Firework) { //If the entity that did the damage was a firework
            // If a Player was damaged
            if (event.getEntity() instanceof Player) {
                final Firework damager = (Firework) event.getDamager();
                final Player damagee = (Player) event.getEntity();
                if (damager.getFireworkMeta().getLore().equals(Arrays.asList(new String[]{"volatileToolExplosion"}.clone()))) { //If it was a firework from a volatile explosion
                    //Negate the damage that the firework does, set the health of the player to half a heart
                    damagee.setHealth(1.0);
                }
            }
            event.setCancelled(true);
            return;
        }
        // End of logic for Volatile Tool Firework Damage Event

        // If a Player did the damage
        if (event.getDamager() instanceof Player){

            // Get the players hand object and ensure that it isn't Material.AIR
            final ItemStack tool = ((Player) event.getDamager()).getInventory().getItemInMainHand();
            if (tool.getType().isAir()){
                return;
            }

            final NBTItem nbti = new NBTItem(tool);
            if (nbti.getString("plugin").equals("Elysium-Items")) { // Check the tool one of the custom items
                final String item = nbti.getString("item");
                
                // Start of logic for Spider Scythe Tool
                if (event.getEntity() instanceof Spider){
                    if (item.equals("SpiderScythe")) {
                        event.setDamage(((Spider) event.getEntity()).getHealth());
                    }
                }
                // End of logic for Spider Scythe Tool

                // Start of logic for Meat Cleaver Tool
                else if (event.getEntity() instanceof Pig ||
                        event.getEntity() instanceof Chicken ||
                        event.getEntity() instanceof Cow ||
                        event.getEntity() instanceof MushroomCow ||
                        event.getEntity() instanceof Sheep ||
                        event.getEntity() instanceof Rabbit){
                    if (item.equals("MeatCleaver")) {
                        event.setDamage(((Animals) event.getEntity()).getHealth());
                    }
                }
                // End of logic for Meat Cleaver Tool

                // Start of logic for Cowards Cutlass Sword & Demonic Sword
                else if (event.getEntity() instanceof Player){

                    // Start of logic for Cowards Cutlass Sword Only
                    if (item.equals("CowardsCutlass")) {
                        final Player damager = (Player) event.getDamager();
                        final ItemMeta itmMeta = tool.getItemMeta();
                        final List<String> meta = itmMeta.getLore();
                        final String line = meta.get(3);
                        final String[] split = line.split("Counter = " + net.md_5.bungee.api.ChatColor.of("#009973"));
                        final int x = Integer.valueOf(split[1]) + 1;
                        meta.set(3, ChatColor.GRAY + "Counter = " + net.md_5.bungee.api.ChatColor.of("#009973") + x);
                        itmMeta.setLore(meta);
                        tool.setItemMeta(itmMeta);
                        damager.getInventory().setItemInMainHand(tool);
                    }
                    // End of logic for Cowards Cutlass Sword Only

                    // Start of logic for Demonic Sword Only
                    else if (item.equals("DemonicSword")) {
                        final Player damager = (Player) event.getDamager();
                        if (Math.random() < 0.2) {
                            if (!onDemonicSwordCooldown(damager)) {
                                final Player damagee = (Player) event.getEntity();
                                damagee.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 200, 0));
                                plugin.getLogger().info(damager.getName() + " inflicted Wither Effect with their Demonic Sword on " + damagee.getName() + ". Cooldown for 30 seconds.");
                                damager.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.getDemonicSwordDamagerMessage(damager.getDisplayName())));
                                damagee.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.getDemonicSwordDamageeMessage(damagee.getDisplayName())));
                                return;
                            }
                        }
                    }
                    // Start of logic for Demonic Sword Only

                }
                // End of logic for Cowards Cutlass Sword & Demonic Sword

            }

        }

    }

    private boolean onDemonicSwordCooldown(Player player){
        if (!demonicSwordCooldownList.contains(player.getUniqueId())){ //If it doesnt containt the key, we need to put the player on cooldown
            demonicSwordCooldownList.add(player.getUniqueId());
            BukkitScheduler scheduler = plugin.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    plugin.getLogger().info(player.getName() + " has been taken off of Demonic Sword cooldown.");
                    demonicSwordCooldownList.remove(player.getUniqueId());
                }
            }, 600L);
            return false; //But they can do it
        }
        return true;
    }

}
