package com.github.lukethadley.elysiumtools.listeners.tools;

import com.github.lukethadley.elysiumtools.ElysiumTools;
import com.github.lukethadley.elysiumtools.ToolsMessages;
import com.github.lukethadley.elysiumtools.items.tools.swords.DemonicSword;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.*;

public class DemonicSwordListener implements Listener {

    ElysiumTools plugin;
    ArrayList<UUID> cooldowns;

    DemonicSword demonicSword;

    public DemonicSwordListener(ElysiumTools plugin){
        this.plugin = plugin;
        cooldowns = new ArrayList<>();
        demonicSword = new DemonicSword();
    }

    @EventHandler
    public void demonicSwordHandler(EntityDamageByEntityEvent e){
        if (e.getEntity() instanceof Player){ //If the entity that was damaged is a player
            if (e.getDamager() instanceof  Player){ //And the entity that damaged that player is a player
                Player damager = (Player) e.getDamager();
                Player damagee = (Player) e.getEntity();

                ItemStack tool = damager.getInventory().getItemInMainHand();
                if (tool == null || tool.getItemMeta().getLore() == null){
                    return;
                }

                if (damager.getInventory().getItemInMainHand().getItemMeta().getLore().equals(Arrays.asList(demonicSword.getLore()))){

                    if (Math.random() < 0.2){
                        if (!onCooldown(damager)){
                            damagee.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 200, 0));
                            plugin.getLogger().info(damager.getName() + " inflicted Wither Effect with their Demonic Sword on " + damagee.getName() + ". Cooldown for 30 seconds.");
                            damager.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.getDemonicSwordDamagerMessage(damager.getDisplayName())));
                            damagee.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.getDemonicSwordDamageeMessage(damagee.getDisplayName())));
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }

    private boolean onCooldown(Player player){
        if (!cooldowns.contains(player.getUniqueId())){ //If it doesnt containt the key, we need to put the player on cooldown
            cooldowns.add(player.getUniqueId());
            BukkitScheduler scheduler = plugin.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    plugin.getLogger().info(player.getName() + " has been taken off of Demonic Sword cooldown.");
                    cooldowns.remove(player.getUniqueId());
                }
            }, 600L);

            return false; //But they can do it
        }
        return true;
    }



}


