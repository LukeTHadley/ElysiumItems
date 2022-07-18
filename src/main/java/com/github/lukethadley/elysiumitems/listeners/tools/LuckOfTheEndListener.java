package com.github.lukethadley.elysiumitems.listeners.tools;

import com.github.lukethadley.elysiumitems.items.tools.pickaxes.LuckOfTheEndPickaxe;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LuckOfTheEndListener implements Listener {

    private static final List<Material> MATERIAL_LIST = Arrays.asList(Material.END_STONE, Material.END_STONE_BRICKS, Material.END_STONE_BRICK_WALL, Material.END_STONE_BRICK_SLAB, Material.END_STONE_BRICK_WALL,
            Material.PURPUR_BLOCK, Material.PURPUR_PILLAR, Material.PURPUR_STAIRS, Material.PURPUR_SLAB,
            Material.MAGENTA_STAINED_GLASS_PANE,
            Material.END_ROD,
            Material.PURPLE_SHULKER_BOX,
            Material.OBSIDIAN,
            Material.DRAGON_HEAD, Material.DRAGON_WALL_HEAD);

    private  List<ItemStack> rewardsList;

    private static LuckOfTheEndPickaxe luckOfTheEndPickaxe;

    private Random rand;

    public LuckOfTheEndListener(){
        luckOfTheEndPickaxe = new LuckOfTheEndPickaxe();
        rewardsList = new ArrayList<>();
        rand = new Random();

        ItemStack book1 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook1 = (EnchantmentStorageMeta) book1.getItemMeta();
        metaBook1.addStoredEnchant(Enchantment.DIG_SPEED, 4, true);
        book1.setItemMeta(metaBook1);

        ItemStack book2 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook2 = (EnchantmentStorageMeta) book2.getItemMeta();
        metaBook2.addStoredEnchant(Enchantment.ARROW_INFINITE, 1, true);
        book2.setItemMeta(metaBook2);

        ItemStack book3 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook3 = (EnchantmentStorageMeta) book3.getItemMeta();
        metaBook3.addStoredEnchant(Enchantment.BINDING_CURSE, 1, true);
        book3.setItemMeta(metaBook3);

        ItemStack book4 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook4 = (EnchantmentStorageMeta) book4.getItemMeta();
        metaBook4.addStoredEnchant(Enchantment.DURABILITY, 3, true);
        book4.setItemMeta(metaBook4);

        ItemStack book5 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook5 = (EnchantmentStorageMeta) book5.getItemMeta();
        metaBook5.addStoredEnchant(Enchantment.KNOCKBACK, 2, true);
        book5.setItemMeta(metaBook5);

        ItemStack book6 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook6 = (EnchantmentStorageMeta) book6.getItemMeta();
        metaBook6.addStoredEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
        book6.setItemMeta(metaBook6);

        ItemStack book7 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook7 = (EnchantmentStorageMeta) book7.getItemMeta();
        metaBook7.addStoredEnchant(Enchantment.MENDING, 1, true);
        book7.setItemMeta(metaBook7);

        ItemStack book8 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook8 = (EnchantmentStorageMeta) book8.getItemMeta();
        metaBook8.addStoredEnchant(Enchantment.PROTECTION_FALL, 4, true);
        book8.setItemMeta(metaBook8);

        ItemStack book9 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook9 = (EnchantmentStorageMeta) book9.getItemMeta();
        metaBook9.addStoredEnchant(Enchantment.SILK_TOUCH, 1, true);
        book9.setItemMeta(metaBook9);

        ItemStack book10 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook10 = (EnchantmentStorageMeta) book10.getItemMeta();
        metaBook10.addStoredEnchant(Enchantment.VANISHING_CURSE, 1, true);
        book10.setItemMeta(metaBook10);

        rewardsList.add(book1);
        rewardsList.add(book2);
        rewardsList.add(book3);
        rewardsList.add(book4);
        rewardsList.add(book5);
        rewardsList.add(book6);
        rewardsList.add(book7);
        rewardsList.add(book8);
        rewardsList.add(book9);
        rewardsList.add(book10);
        rewardsList.add(new ItemStack(Material.DIAMOND, 2));
        rewardsList.add(new ItemStack(Material.IRON_INGOT, 2));
        rewardsList.add(new ItemStack(Material.EMERALD, 2));
        rewardsList.add(new ItemStack(Material.GOLD_INGOT, 12));
        rewardsList.add(new ItemStack(Material.LAPIS_LAZULI, 3));
        rewardsList.add(new ItemStack(Material.SHULKER_SHELL, 1));
        rewardsList.add(new ItemStack(Material.EXPERIENCE_BOTTLE, 8));
        rewardsList.add(new ItemStack(Material.CAKE, 1));
        rewardsList.add(new ItemStack(Material.NETHERITE_SCRAP, 1));
        rewardsList.add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1));
        rewardsList.add(new ItemStack(Material.TOTEM_OF_UNDYING, 1));

    }

    @EventHandler
    public void luckyEndListener(BlockBreakEvent e){
        if (e.getBlock().getWorld().getEnvironment() == World.Environment.THE_END) { //If the player is in the end
            ItemStack tool = e.getPlayer().getInventory().getItemInMainHand();
            NBTItem nbti = new NBTItem(tool);

            String plugin = nbti.getString("plugin");
            String item = nbti.getString("item");
            if (plugin.equals("Elysium-Items")) {
                if (item.equals("LuckOfTheEndPickaxe")) {
                    if (MATERIAL_LIST.contains(e.getBlock().getBlockData().getMaterial())) { // If it is a end block
                        e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), rewardsList.get(rand.nextInt(rewardsList.size())));
                        return;
                    }
                }
            }
        }
        return;
    }
}
