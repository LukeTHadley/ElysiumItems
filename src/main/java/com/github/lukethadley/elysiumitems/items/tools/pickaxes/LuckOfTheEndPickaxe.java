package com.github.lukethadley.elysiumitems.items.tools.pickaxes;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class LuckOfTheEndPickaxe extends CustomItem {

    private static final String NAME = "LuckOfTheEndPickaxe";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#dd99ff") + "&lLuck Of The End Pickaxe";
    private static final String DESCRIPTION = "This pickaxe will drop extra loot while mining end blocks in the end!";
    private static final String[] ITEM_LORE = new String[]{"&7This pickaxe will drop", "&7extra loot while mining", "&7end blocks in the end!"};

    public LuckOfTheEndPickaxe(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.GOLDEN_PICKAXE);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));


        itmMeta.addEnchant(Enchantment.LUCK, 1, true);
        itmMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itmStk.setItemMeta(itmMeta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", NAME);

        nbti.applyNBT(itmStk);

        return itmStk;
    }

}
