package com.github.lukethadley.elysiumitems.items.armor.helmets;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class NightOwlHelmet extends CustomItem {

    private static final String NAME = "NightOwlHelmet";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#2c1db3") + "&lNight Owl Helmet";
    private static final String DESCRIPTION = "This item will give the user Haste while they are wearing it!";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#2c1db3") + "Like an Owl!", "&7Gives the user Night Vision while", "&7they are wearing the helmet!"};

    public NightOwlHelmet(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.LEATHER_HELMET);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);

        LeatherArmorMeta meta = (LeatherArmorMeta) itmStk.getItemMeta();
        meta.setColor(Color.fromRGB(44, 29, 179));

        meta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        meta.setLore(Arrays.asList(getLore()));

        itmStk.setItemMeta(meta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", NAME);
        nbti.applyNBT(itmStk);

        return itmStk;

    }
}
