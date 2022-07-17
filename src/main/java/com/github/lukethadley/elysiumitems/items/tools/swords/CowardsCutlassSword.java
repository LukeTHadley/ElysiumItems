package com.github.lukethadley.elysiumitems.items.tools.swords;

import com.github.lukethadley.elysiumitems.HexColorFactory;
import com.github.lukethadley.elysiumitems.items.CustomItem;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CowardsCutlassSword extends CustomItem {

    private static final String NAME = "CowardsCuttlas";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#009973") + "" + ChatColor.BOLD + "Cowards Cuttlas";
    private static final String DESCRIPTION = "Sword with knockback 8";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#009973") + "YEEEEEEEEET!","&7This sword will count the number", "&7of players it has cast aside!", "&7Counter = " + net.md_5.bungee.api.ChatColor.of("#009973") + "0"};

    public CowardsCutlassSword(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.STONE_SWORD);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));

        itmMeta.addEnchant(Enchantment.KNOCKBACK, 8, true);
        itmMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        itmMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);


        itmStk.setItemMeta(itmMeta);
        return itmStk;
    }

}
