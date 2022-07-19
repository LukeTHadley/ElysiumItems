package com.github.lukethadley.elysiumitems.items.tools;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import com.github.lukethadley.elysiumitems.items.tools.axes.MeatCleaver;
import com.github.lukethadley.elysiumitems.items.tools.axes.VolatileAxe;
import com.github.lukethadley.elysiumitems.items.tools.bows.LightningBow;
import com.github.lukethadley.elysiumitems.items.tools.fishingrods.CodFatherRod;
import com.github.lukethadley.elysiumitems.items.tools.hoes.SpiderScythe;
import com.github.lukethadley.elysiumitems.items.tools.hoes.VolatileHoe;
import com.github.lukethadley.elysiumitems.items.tools.pickaxes.*;
import com.github.lukethadley.elysiumitems.items.tools.shovels.FurnaceShovel;
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
        LightningBow lightningBow = new LightningBow();
        customItems.put(lightningBow.getName(), lightningBow);

        //Shovels
        FurnaceShovel furnaceShovel = new FurnaceShovel();
        customItems.put(furnaceShovel.getName(), furnaceShovel);

        //Axes
        MeatCleaver meatCleaver = new MeatCleaver();
        customItems.put(meatCleaver.getName(), meatCleaver);

        //Pickaxes
        LuckOfTheEndPickaxe luckOfTheEndPickaxe = new LuckOfTheEndPickaxe();
        customItems.put(luckOfTheEndPickaxe.getName(), luckOfTheEndPickaxe);
        LuckOfTheNetherPickaxe luckOfTheNetherPickaxe = new LuckOfTheNetherPickaxe();
        customItems.put(luckOfTheNetherPickaxe.getName(), luckOfTheNetherPickaxe);
        LuckOfTheOceanPickaxe luckOfTheOceanPickaxe = new LuckOfTheOceanPickaxe();
        customItems.put(luckOfTheOceanPickaxe.getName(), luckOfTheOceanPickaxe);
        CruciblePickaxe cruciblePickaxe = new CruciblePickaxe();
        customItems.put(cruciblePickaxe.getName(), cruciblePickaxe);
        MagnetPickaxe magnetPickaxe = new MagnetPickaxe();
        customItems.put(magnetPickaxe.getName(), magnetPickaxe);

        //Fishing Rods
        CodFatherRod codFatherRod = new CodFatherRod();
        customItems.put(codFatherRod.getName(), codFatherRod);

        //Hoes
        SpiderScythe spiderScythe = new SpiderScythe();
        customItems.put(spiderScythe.getName(), spiderScythe);

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
