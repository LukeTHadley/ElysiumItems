package com.github.lukethadley.elysiumitems.items.tools.pickaxes;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CruciblePickaxe extends CustomItem {

    private static final String NAME = "CruciblePickaxe";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#ff8800") + "&lCrucible Pickaxe";
    private static final String DESCRIPTION = "This pickaxe will auto smelt all ores!";
    private static final String[] ITEM_LORE = new String[]{net.md_5.bungee.api.ChatColor.of("#ff8800") + "OUCH! OUCH! HOT! HOT!", "&7This pickaxe will auto smelt", "&7iron, copper and gold ores!"};

    public CruciblePickaxe(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.DIAMOND_PICKAXE);
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
        nbti.setBoolean("modifiable", true);
        nbti.setString("item", NAME);

        nbti.applyNBT(itmStk);

        return itmStk;
    }
}
