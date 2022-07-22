package com.github.lukethadley.elysiumitems.items.armor.boots;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class VoyagerBoots extends CustomItem {

    private static final String NAME = "VoyagerBoots";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#ffb3ff") + "&lVoyager Boots";
    private static final String DESCRIPTION = "When worn in the full set, the user will gain 4 extra hearts!";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#ffb3ff") + "My what a big heart you have!", "&7When worn in the full set, the", "&7user will gain 4 extra hearts!",
            "&8This item is not &8modifiable/fixable!"};

    public VoyagerBoots(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.CHAINMAIL_BOOTS);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);

        ItemMeta meta = itmStk.getItemMeta();

        meta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        meta.setLore(Arrays.asList(getLore()));

        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta.addEnchant(Enchantment.PROTECTION_FALL, 3, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);

        itmStk.setItemMeta(meta);
        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", "Voyager");
        nbti.applyNBT(itmStk);
        return itmStk;
    }

}