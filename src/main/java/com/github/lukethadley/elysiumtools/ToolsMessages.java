package com.github.lukethadley.elysiumtools;

public class ToolsMessages {

    public static final String PLUGIN_PREFIX = "&8(&3Elysium Items&8) ";

    public static final String ENDER_BOW_NO_ENDERPEARL_EVENT = PLUGIN_PREFIX + "&7Sorry, you must have an &dEnder Pearl &7in your inventory to shoot this bow.";

    public static final String SHOTGUN_BOW_NOT_ENOUGH_ARROWS = PLUGIN_PREFIX + "&7Sorry, you must have at least &b5 Arrows &7in your inventory to shoot this bow.";


    public static final String SHOTGUN_BOW_USE_MESSAGE = PLUGIN_PREFIX + "&7You used your Shotgun Bow! &7Please wait 6 seconds before using again.";


    public static final String LIST_ALL_TOOLS_HEADER = "&8------ &3Elysium Tools &8-----";
    public static final String LIST_ALL_TOOLS_FOOTER = "&8--------------------------";



    public static String getDemonicSwordDamagerMessage(String name){
        return PLUGIN_PREFIX + "&7You used your Demonic Sword &7and inflicted the Wither Effect on " + name + " &7for 10 seconds!" +
                "\n&7You can not use this ability for another 30 seconds.";
    }

    public static String getDemonicSwordDamageeMessage(String name){
        return PLUGIN_PREFIX + name + " &7used their Demonic Sword &7and inflicted you with the Wither Effect for 10 seconds!";
    }

}
