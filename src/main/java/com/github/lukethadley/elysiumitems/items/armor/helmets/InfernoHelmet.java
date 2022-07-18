package com.github.lukethadley.elysiumitems.items.armor.helmets;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class InfernoHelmet extends CustomItem {

    private static final String NAME = "InfernoHelmet";
    private static final String ITEM_DISPLAY_NAME = net.md_5.bungee.api.ChatColor.of("#cc0000") + "&lInferno Helmet";
    private static final String DESCRIPTION = "When worn in the full set, the user will gain night fire resistance when in lava!";
    private static final String[] ITEM_LORE = new String[]{
            net.md_5.bungee.api.ChatColor.of("#cc0000") + "D" +
                    net.md_5.bungee.api.ChatColor.of("#cc6600") + "i" +
                    net.md_5.bungee.api.ChatColor.of("#cccc00") + "s" +
                    net.md_5.bungee.api.ChatColor.of("#66cc00") + "c" +
                    net.md_5.bungee.api.ChatColor.of("#66cc00") + "o " +
                    net.md_5.bungee.api.ChatColor.of("#00cc99") + "I" +
                    net.md_5.bungee.api.ChatColor.of("#0099cc") + "n" +
                    net.md_5.bungee.api.ChatColor.of("#0033cc") + "f" +
                    net.md_5.bungee.api.ChatColor.of("#3300cc") + "e" +
                    net.md_5.bungee.api.ChatColor.of("#9900cc") + "r" +
                    net.md_5.bungee.api.ChatColor.of("#cc0099") + "n" +
                    net.md_5.bungee.api.ChatColor.of("#cc0033") + "o",
            "&7When worn in the full set, ", "&7the user will gain fire", "&7resistance in lava!"};

    public InfernoHelmet(){
        super(NAME, ITEM_DISPLAY_NAME, DESCRIPTION, ITEM_LORE, Material.LEATHER_HELMET);
    }

    @Override
    public ItemStack getItem() {
        ItemStack itmStk = new ItemStack(getItemType(), 1);


        LeatherArmorMeta meta = (LeatherArmorMeta) itmStk.getItemMeta();
        meta.setColor(Color.fromRGB(204, 0, 0));

        meta.setDisplayName(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', getItemName()));
        meta.setLore(Arrays.asList(getLore()));

        meta.addEnchant(Enchantment.DURABILITY, 3, true);

        itmStk.setItemMeta(meta);

        NBTItem nbti = new NBTItem(itmStk);
        nbti.setString("plugin", "Elysium-Items");
        nbti.setString("item", "Inferno");
        nbti.applyNBT(itmStk);
        return itmStk;
    }
}
