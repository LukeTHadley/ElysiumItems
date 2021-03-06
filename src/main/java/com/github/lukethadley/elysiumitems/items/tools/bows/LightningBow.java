package com.github.lukethadley.elysiumitems.items.tools.bows;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class LightningBow extends CustomItem {

    private static final String NAME = "LightningBow";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#bfff00") + "" + ChatColor.BOLD + "Lightning Bow";
    private static final String DESCRIPTION = "Has a 10% chance of summoning lightning where the arrow lands.";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#bfff00") + "Summon Lightning!", ChatColor.GRAY + "Has a 10% chance of summoning", ChatColor.GRAY +  "lightning when the arrow lands!",
            "&8This item is not &8modifiable/fixable!"};

    public LightningBow(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.BOW);
    }


    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));

        itmMeta.addEnchant(Enchantment.DURABILITY, 3, true);

        itmStk.setItemMeta(itmMeta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", NAME);

        nbti.applyNBT(itmStk);
        return itmStk;
    }
}
