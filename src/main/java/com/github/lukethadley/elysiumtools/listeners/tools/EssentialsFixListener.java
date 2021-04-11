package com.github.lukethadley.elysiumtools.listeners.tools;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class EssentialsFixListener implements Listener {

    @EventHandler
    private void test(PlayerCommandPreprocessEvent e){
        //System.out.println(e.getMessage());
        //e.setCancelled(true); Add content here to stop essentials fixing on specific items that should not be fixed.
    }
}
