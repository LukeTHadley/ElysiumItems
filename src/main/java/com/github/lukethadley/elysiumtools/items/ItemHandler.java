package com.github.lukethadley.elysiumtools.items;

import com.github.lukethadley.elysiumtools.items.armor.boots.BunnyBoots;
import com.github.lukethadley.elysiumtools.items.tools.axes.VolatileAxe;
import com.github.lukethadley.elysiumtools.items.tools.hoes.VolatileHoe;
import com.github.lukethadley.elysiumtools.items.tools.pickaxes.LuckOfTheEndPickaxe;
import com.github.lukethadley.elysiumtools.items.tools.pickaxes.LuckOfTheNetherPickaxe;
import com.github.lukethadley.elysiumtools.items.tools.pickaxes.LuckOfTheOceanPickaxe;
import com.github.lukethadley.elysiumtools.items.tools.pickaxes.VolatilePickaxe;
import com.github.lukethadley.elysiumtools.items.tools.shovels.VolatileShovel;
import com.github.lukethadley.elysiumtools.items.tools.swords.DemonicSword;
import com.github.lukethadley.elysiumtools.items.tools.swords.VolatileSword;
import com.github.lukethadley.elysiumtools.items.tools.bows.EnderBow;
import com.github.lukethadley.elysiumtools.items.tools.bows.ShotgunBow;

import java.util.HashMap;

public class ItemHandler {

    private HashMap<String, CustomItem> customItems;

    public ItemHandler(){
        customItems = new HashMap<>();
        addItemsToMap();
    }

    private void addItemsToMap(){
        //Swords

        DemonicSword demonicSword = new DemonicSword();
        customItems.put(demonicSword.getName(), demonicSword);


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

        //Boots
        BunnyBoots bunnyBoots = new BunnyBoots();
        customItems.put(bunnyBoots.getName(), bunnyBoots);

    }

    public HashMap<String, CustomItem> getCustomItems(){
        return customItems;
    }

    public boolean checkExist(String customItemName){
        return customItems.containsKey(customItemName);
    }

}
