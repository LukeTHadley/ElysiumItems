package com.github.lukethadley.elysiumitems.items.armor.boots;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class SlimeSlippers extends CustomItem {

    private static final String NAME = "SlimeSlippers";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#40db76") + "&lSlime Slippers";
    private static final String DESCRIPTION = "This item has feather falling 8!";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#40db76") + "Squelch... Squelch... Squelch...", "&7Just some nice feather falling boots!"};

    public SlimeSlippers(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.LEATHER_BOOTS);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);


        LeatherArmorMeta meta = (LeatherArmorMeta) itmStk.getItemMeta();
        meta.setColor(Color.fromRGB(64, 219, 118));

        meta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        meta.setLore(Arrays.asList(getLore()));


        meta.addEnchant(Enchantment.PROTECTION_FALL, 8, true);

        itmStk.setItemMeta(meta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", NAME);
        nbti.applyNBT(itmStk);
        return itmStk;
    }
}
