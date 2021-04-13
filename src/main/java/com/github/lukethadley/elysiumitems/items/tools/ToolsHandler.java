package com.github.lukethadley.elysiumitems.items.tools;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import com.github.lukethadley.elysiumitems.items.armor.boots.BunnyBoots;
import com.github.lukethadley.elysiumitems.items.armor.boots.VoyagerBoots;
import com.github.lukethadley.elysiumitems.items.armor.chestplate.VoyagerChestplate;
import com.github.lukethadley.elysiumitems.items.armor.helmets.MinersHelmet;
import com.github.lukethadley.elysiumitems.items.armor.helmets.VoyagerHelmet;
import com.github.lukethadley.elysiumitems.items.armor.leggings.VoyagerLeggings;
import com.github.lukethadley.elysiumitems.items.tools.axes.VolatileAxe;
import com.github.lukethadley.elysiumitems.items.tools.hoes.VolatileHoe;
import com.github.lukethadley.elysiumitems.items.tools.pickaxes.LuckOfTheEndPickaxe;
import com.github.lukethadley.elysiumitems.items.tools.pickaxes.LuckOfTheNetherPickaxe;
import com.github.lukethadley.elysiumitems.items.tools.pickaxes.LuckOfTheOceanPickaxe;
import com.github.lukethadley.elysiumitems.items.tools.pickaxes.VolatilePickaxe;
import com.github.lukethadley.elysiumitems.items.tools.shovels.VolatileShovel;
import com.github.lukethadley.elysiumitems.items.tools.swords.CowardsCutlassSword;
import com.github.lukethadley.elysiumitems.items.tools.swords.DemonicSword;
import com.github.lukethadley.elysiumitems.items.tools.swords.VolatileSword;
import com.github.lukethadley.elysiumitems.items.tools.bows.EnderBow;
import com.github.lukethadley.elysiumitems.items.tools.bows.ShotgunBow;

import java.util.HashMap;

public class ToolsHandler {

    private HashMap<String, CustomItem> customItems;

    public ToolsHandler(){
        customItems = new HashMap<>();
        addItemsToMap();
    }

    private void addItemsToMap(){
        //Swords

        DemonicSword demonicSword = new DemonicSword();
        customItems.put(demonicSword.getName(), demonicSword);
        CowardsCutlassSword cowardsCutlassSword = new CowardsCutlassSword();
        customItems.put(cowardsCutlassSword.getName(), cowardsCutlassSword);

        //Bows
        EnderBow enderBow = new EnderBow();
        customItems.put(enderBow.getName(), enderBow);
        ShotgunBow shotgunBow = new ShotgunBow();
        customItems.put(shotgunBow.getName(), shotgunBow);

        //Pickaxes
        LuckOfTheEndPickaxe luckOfTheEndPickaxe = new LuckOfTheEndPickaxe();
        customItems.put(luckOfTheEndPickaxe.getName(), luckOfTheEndPickaxe);
        LuckOfTheNetherPickaxe luckOfTheNetherPickaxe = new LuckOfTheNetherPickaxe();
        customItems.put(luckOfTheNetherPickaxe.getName(), luckOfTheNetherPickaxe);
        LuckOfTheOceanPickaxe luckOfTheOceanPickaxe = new LuckOfTheOceanPickaxe();
        customItems.put(luckOfTheOceanPickaxe.getName(), luckOfTheOceanPickaxe);

        //Volatile Items
        VolatileSword volatileSword = new VolatileSword();
        customItems.put(volatileSword.getName(), volatileSword);
        VolatileAxe volatileAxe = new VolatileAxe();
        customItems.put(volatileAxe.getName(), volatileAxe);
        VolatileShovel volatileShovel = new VolatileShovel();
        customItems.put(volatileShovel.getName(), volatileShovel);
        VolatilePickaxe volatilePickaxe = new VolatilePickaxe();
        customItems.put(volatilePickaxe.getName(), volatilePickaxe);
        VolatileHoe volatileHoe = new VolatileHoe();
        customItems.put(volatileHoe.getName(), volatileHoe);
    }

    public HashMap<String, CustomItem> getCustomItems(){
        return customItems;
    }

    public boolean checkExist(String customItemName){
        return customItems.containsKey(customItemName);
    }

}
