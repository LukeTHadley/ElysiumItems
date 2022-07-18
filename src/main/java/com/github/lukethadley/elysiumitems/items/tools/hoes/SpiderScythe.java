package com.github.lukethadley.elysiumitems.items.tools.hoes;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SpiderScythe extends CustomItem {

    private static final String NAME = "SpiderScythe";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#a376a1") + "&lSpider Scythe";
    private static final String DESCRIPTION = "This item will one hit Spiders and Cave Spiders!";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#a376a1") + "Ewwwwwww! Spider! Kill it!", "&7Kills Spiders in one hit."};

    public SpiderScythe(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.GOLDEN_HOE);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);
        ItemMeta itmMeta = itmStk.getItemMeta();

        itmMeta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        itmMeta.setLore(Arrays.asList(getLore()));

        itmStk.setItemMeta(itmMeta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", NAME);

        nbti.applyNBT(itmStk);
        return itmStk;
    }
}
