/*
https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerItemBreakEvent.html
 */


package com.github.lukethadley.elysiumitems.listeners.tools;

import com.github.lukethadley.elysiumitems.items.tools.axes.VolatileAxe;
import com.github.lukethadley.elysiumitems.items.tools.hoes.VolatileHoe;
import com.github.lukethadley.elysiumitems.items.tools.pickaxes.VolatilePickaxe;
import com.github.lukethadley.elysiumitems.items.tools.shovels.VolatileShovel;
import com.github.lukethadley.elysiumitems.items.tools.swords.VolatileSword;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VolatileToolListener implements Listener {

    private static final List<String> VOLATILE_FIREWORK_LORE_TAG = Arrays.asList(new String[]{"volatileToolExplosion"}.clone());
    private static final List<Color> COLOR_LIST = Arrays.asList(Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW);

    public static Random rand;

    VolatileAxe volatileAxe;
    VolatileHoe volatileHoe;
    VolatilePickaxe volatilePickaxe;
    VolatileShovel volatileShovel;
    VolatileSword volatileSword;

    public VolatileToolListener(){
        volatileAxe = new VolatileAxe();
        volatileHoe = new VolatileHoe();
        volatilePickaxe = new VolatilePickaxe();
        volatileShovel = new VolatileShovel();
        volatileSword = new VolatileSword();
        rand = new Random();
    }

    //Run the firework on item breaking
    @EventHandler
    public void volatileToolExplosion(PlayerItemBreakEvent e){

        final ItemStack itmStk = e.getBrokenItem();

        if (itmStk == null || itmStk.getType().isAir()){
            return;
        }
        final NBTItem nbti = new NBTItem(itmStk);

        final String plugin = nbti.getString("plugin");
        final String item = nbti.getString("item");
        if (plugin.equals("Elysium-Items")){
            if (item.equals("Volatile")) {
                Location loc = e.getPlayer().getLocation();
                loc.setY(loc.getY() + 1);

                Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
                FireworkMeta fwm = fw.getFireworkMeta();

                fwm.addEffect(FireworkEffect.builder().withColor(COLOR_LIST.get(rand.nextInt(COLOR_LIST.size()))).flicker(true).build());
                fwm.addEffect(FireworkEffect.builder().withColor(COLOR_LIST.get(rand.nextInt(COLOR_LIST.size()))).trail(true).build());

                fwm.setLore(VOLATILE_FIREWORK_LORE_TAG);

                fw.setFireworkMeta(fwm);
                fw.detonate();
            }
        }
        return;
    }

}
