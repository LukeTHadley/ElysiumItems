package com.github.lukethadley.elysiumitems.items.tools.bows;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class EnderBow extends CustomItem {

    private static final String NAME = "EnderBow";
    private static final String ITEM_DISPLAY_NAME = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Ender Bow";
    private static final String DESCRIPTION = "Shoot an Ender Pearl with a bow and go where it lands";
    private static final String[] ITEM_LORE = new String[]{ChatColor.GRAY + "Shoot Pearls! Not Arrows!", ChatColor.GRAY + "You must have " + ChatColor.LIGHT_PURPLE + "one arrow " + ChatColor.GRAY + "and", ChatColor.GRAY + "an " + ChatColor.LIGHT_PURPLE +"Ender Pearl" + ChatColor.GRAY +  " in your", ChatColor.GRAY + "inventory to use this bow!",
    "&8This item is not &8modifiable/fixable!"};

    public EnderBow(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.BOW);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));

        itmMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        itmMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        itmStk.setItemMeta(itmMeta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", "EnderBow");

        nbti.applyNBT(itmStk);
        return itmStk;
    }

}
