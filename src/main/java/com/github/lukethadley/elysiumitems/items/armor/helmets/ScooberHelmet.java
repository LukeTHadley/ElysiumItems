package com.github.lukethadley.elysiumitems.items.armor.helmets;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class ScooberHelmet extends CustomItem {

    private static final String NAME = "ScooberHelmet";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#4d94ff") + "&lScoober Helmet";
    private static final String DESCRIPTION = "When worn in the full set, the user will gain night vision/water breathing when under water!";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#4d94ff") + "Deep Sea Diving!", "&7When worn in the full set the", "&7user will gain night vision/water", "&7breathing when under water!",
            "&8This item is not &8modifiable/fixable!"};

    public ScooberHelmet(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.LEATHER_HELMET);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);

        LeatherArmorMeta meta = (LeatherArmorMeta) itmStk.getItemMeta();

        Color color = Color.fromRGB(61, 61, 134);
        meta.setColor(color);

        meta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        meta.setLore(Arrays.asList(getLore()));

        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);

        itmStk.setItemMeta(meta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", NAME);
        nbti.applyNBT(itmStk);

        return itmStk;
    }

}
