package com.github.lukethadley.elysiumitems.listeners.tools;

import com.github.lukethadley.elysiumitems.items.tools.pickaxes.LuckOfTheOceanPickaxe;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
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

public class LuckOfTheOceanListener implements Listener {

    private static final List<Material> MATERIAL_LIST = Arrays.asList(
            Material.BRAIN_CORAL, Material.BRAIN_CORAL_BLOCK, Material.BRAIN_CORAL_FAN, Material.BRAIN_CORAL_WALL_FAN, Material.DEAD_BRAIN_CORAL,
            Material.BUBBLE_CORAL, Material.BUBBLE_CORAL_BLOCK, Material.BUBBLE_CORAL_FAN, Material.BUBBLE_CORAL_WALL_FAN, Material.DEAD_BUBBLE_CORAL,
            Material.FIRE_CORAL, Material.FIRE_CORAL_BLOCK, Material.FIRE_CORAL_FAN, Material.FIRE_CORAL_WALL_FAN, Material.DEAD_FIRE_CORAL,
            Material.HORN_CORAL, Material.HORN_CORAL_BLOCK, Material.HORN_CORAL_FAN, Material.HORN_CORAL_WALL_FAN, Material.DEAD_HORN_CORAL,
            Material.TUBE_CORAL, Material.TUBE_CORAL_BLOCK, Material.TUBE_CORAL_FAN, Material.TUBE_CORAL_WALL_FAN, Material.DEAD_TUBE_CORAL,
            Material.SEA_PICKLE,
            Material.SEA_LANTERN,
            Material.PRISMARINE, Material.PRISMARINE_SLAB, Material.PRISMARINE_STAIRS, Material.PRISMARINE_WALL,
            Material.PRISMARINE_BRICKS, Material.PRISMARINE_BRICK_SLAB, Material.PRISMARINE_BRICK_STAIRS,
            Material.DARK_PRISMARINE, Material.DARK_PRISMARINE_SLAB, Material.DARK_PRISMARINE_STAIRS,
            Material.SEAGRASS, Material.TALL_SEAGRASS,
            Material.KELP, Material.KELP_PLANT
    );

    private static final List<Biome> BIOME_LIST = Arrays.asList(Biome.WARM_OCEAN, Biome.OCEAN, Biome.LUKEWARM_OCEAN, Biome.DEEP_LUKEWARM_OCEAN, Biome.DEEP_OCEAN, Biome.FROZEN_OCEAN, Biome.DEEP_FROZEN_OCEAN, Biome.COLD_OCEAN, Biome.DEEP_COLD_OCEAN);

    private  List<ItemStack> rewardsList;

    private static LuckOfTheOceanPickaxe luckOfTheOceanPickaxe;

    private Random rand;

    public LuckOfTheOceanListener(){
        luckOfTheOceanPickaxe = new LuckOfTheOceanPickaxe();
        rewardsList = new ArrayList<>();
        rand = new Random();

        ItemStack book1 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook1 = (EnchantmentStorageMeta) book1.getItemMeta();
        metaBook1.addStoredEnchant(Enchantment.DEPTH_STRIDER, 3, true);
        book1.setItemMeta(metaBook1);

        ItemStack book2 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook2 = (EnchantmentStorageMeta) book2.getItemMeta();
        metaBook2.addStoredEnchant(Enchantment.FROST_WALKER, 2, true);
        book2.setItemMeta(metaBook2);

        ItemStack book3 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook3 = (EnchantmentStorageMeta) book3.getItemMeta();
        metaBook3.addStoredEnchant(Enchantment.IMPALING, 1, true);
        book3.setItemMeta(metaBook3);

        ItemStack book4 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook4 = (EnchantmentStorageMeta) book4.getItemMeta();
        metaBook4.addStoredEnchant(Enchantment.RIPTIDE, 1, true);
        book4.setItemMeta(metaBook4);

        ItemStack book5 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook5 = (EnchantmentStorageMeta) book5.getItemMeta();
        metaBook5.addStoredEnchant(Enchantment.LOYALTY, 1, true);
        book5.setItemMeta(metaBook5);

        ItemStack book6 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook6 = (EnchantmentStorageMeta) book6.getItemMeta();
        metaBook6.addStoredEnchant(Enchantment.CHANNELING, 1, true);
        book6.setItemMeta(metaBook6);

        ItemStack book7 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook7 = (EnchantmentStorageMeta) book7.getItemMeta();
        metaBook7.addStoredEnchant(Enchantment.LUCK, 3, true);
        book7.setItemMeta(metaBook7);

        ItemStack book8 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook8 = (EnchantmentStorageMeta) book8.getItemMeta();
        metaBook8.addStoredEnchant(Enchantment.LURE, 3, true);
        book8.setItemMeta(metaBook8);

        ItemStack book9 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook9 = (EnchantmentStorageMeta) book9.getItemMeta();
        metaBook9.addStoredEnchant(Enchantment.BINDING_CURSE, 1, true);
        book9.setItemMeta(metaBook9);

        ItemStack book10 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook10 = (EnchantmentStorageMeta) book10.getItemMeta();
        metaBook10.addStoredEnchant(Enchantment.VANISHING_CURSE, 1, true);
        book10.setItemMeta(metaBook10);

        ItemStack book11 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook11 = (EnchantmentStorageMeta) book11.getItemMeta();
        metaBook11.addStoredEnchant(Enchantment.OXYGEN, 1, true);
        book11.setItemMeta(metaBook11);

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
        rewardsList.add(book11);
        rewardsList.add(new ItemStack(Material.TRIDENT, 1));
        rewardsList.add(new ItemStack(Material.SCUTE, 1));
        rewardsList.add(new ItemStack(Material.CONDUIT, 1));
        rewardsList.add(new ItemStack(Material.HEART_OF_THE_SEA, 1));
        rewardsList.add(new ItemStack(Material.NAUTILUS_SHELL, 1));
        rewardsList.add(new ItemStack(Material.PUFFERFISH_BUCKET, 1));
        rewardsList.add(new ItemStack(Material.TROPICAL_FISH_BUCKET, 1));
        rewardsList.add(new ItemStack(Material.SALMON_BUCKET, 1));
        rewardsList.add(new ItemStack(Material.TURTLE_EGG, 4));
        rewardsList.add(new ItemStack(Material.SEA_PICKLE, 4));
        rewardsList.add(new ItemStack(Material.SEA_LANTERN, 4));
        rewardsList.add(new ItemStack(Material.DIAMOND, 1));
        rewardsList.add(new ItemStack(Material.GOLD_INGOT, 1));
        rewardsList.add(new ItemStack(Material.SPONGE, 2));
        rewardsList.add(new ItemStack(Material.COD, 2));
        rewardsList.add(new ItemStack(Material.SALMON, 2));
        rewardsList.add(new ItemStack(Material.PUFFERFISH, 1));

    }

    @EventHandler
    public void luckyEndListener(BlockBreakEvent e) {
        ItemStack tool = e.getPlayer().getInventory().getItemInMainHand();
        NBTItem nbti = new NBTItem(tool);

        String plugin = nbti.getString("plugin");
        String item = nbti.getString("item");
        if (plugin.equals("Elysium-Items")) {
            if (item.equals("LuckOfTheOceanPickaxe")) {
                if (e.getBlock().getWorld().getEnvironment() == World.Environment.NORMAL) { //If the player is in the end
                    if (BIOME_LIST.contains(e.getBlock().getWorld().getBlockAt(e.getBlock().getLocation()).getBiome())) {
                        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().equals(luckOfTheOceanPickaxe.getLoreAsListString())) {
                            if (MATERIAL_LIST.contains(e.getBlock().getBlockData().getMaterial())) { // If it is a end block
                                e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), rewardsList.get(rand.nextInt(rewardsList.size())));
                            }
                        }
                    }
                }
            }
        }
    }

}
