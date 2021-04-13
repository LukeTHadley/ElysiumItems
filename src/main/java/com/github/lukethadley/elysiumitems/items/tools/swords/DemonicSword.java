package com.github.lukethadley.elysiumitems.items.tools.swords;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class DemonicSword extends CustomItem {

    private static final String NAME = "DemonicSword";
    private static final String ITEM_DISPLAY_NAME = ChatColor.DARK_RED + "" + ChatColor.BOLD + "Demonic Sword";
    private static final String DESCRIPTION = "Has a 20% chance of applying wither effect to your enemy for 10 seconds";
    private static final String[] ITEM_LORE = new String[]{ChatColor.DARK_PURPLE + "Forged in the depths of hell", ChatColor.GRAY + "Has a 20% chance of applying the", ChatColor.GRAY + "wither effect to your enemy for 10 seconds"};

    public DemonicSword(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.STONE_SWORD);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));

        itmMeta.addEnchant(Enchantment.DURABILITY, 6, true);


        itmStk.setItemMeta(itmMeta);
        return itmStk;
    }

}
