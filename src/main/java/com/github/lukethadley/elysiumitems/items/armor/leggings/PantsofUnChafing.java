package com.github.lukethadley.elysiumitems.items.armor.leggings;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class PantsofUnChafing extends CustomItem {

    private static final String NAME = "PantsOfUnChafing";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#a944db") + "&lPants of Un-Chafing";
    private static final String DESCRIPTION = "This pair of leggings gives the users Speed 1 when worn!";
    private static final String[] ITEM_LORE = new String[]{
            net.md_5.bungee.api.ChatColor.of("#a944db") + "Smoooooth legs...",  "&7When worn you will", "&7get Speed 1!",
            "&8This item is not &8modifiable/fixable!"};


    public PantsofUnChafing (){ super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.LEATHER_LEGGINGS); }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);

        LeatherArmorMeta meta = (LeatherArmorMeta) itmStk.getItemMeta();
        meta.setColor(Color.fromRGB(169, 68, 219));

        meta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        meta.setLore(Arrays.asList(getLore()));

        meta.addEnchant(Enchantment.DURABILITY, 5, true);

        itmStk.setItemMeta(meta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", NAME);
        nbti.applyNBT(itmStk);
        return itmStk;
    }

}
