package com.github.lukethadley.elysiumitems.listeners.tools;

import com.github.lukethadley.elysiumitems.items.tools.pickaxes.LuckOfTheNetherPickaxe;
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

public class LuckOfTheNetherListener implements Listener {

    private static final List<Material> MATERIAL_LIST = Arrays.asList(Material.ANCIENT_DEBRIS,
            Material.BASALT, Material.POLISHED_BASALT,
            Material.BLACKSTONE, Material.BLACKSTONE_SLAB, Material.BLACKSTONE_STAIRS, Material.BLACKSTONE_WALL, Material.CHISELED_POLISHED_BLACKSTONE, Material.CRACKED_POLISHED_BLACKSTONE_BRICKS, Material.GILDED_BLACKSTONE,
            Material.POLISHED_BLACKSTONE, Material.POLISHED_BLACKSTONE_BRICK_SLAB, Material.POLISHED_BLACKSTONE_BRICK_STAIRS, Material.POLISHED_BLACKSTONE_BRICK_WALL, Material.POLISHED_BLACKSTONE_BRICKS, Material.POLISHED_BLACKSTONE_BUTTON, Material.POLISHED_BLACKSTONE_PRESSURE_PLATE, Material.POLISHED_BLACKSTONE_SLAB, Material.POLISHED_BLACKSTONE_STAIRS, Material.POLISHED_BLACKSTONE_WALL, Material.POLISHED_BLACKSTONE_BRICK_WALL, Material.POLISHED_BLACKSTONE_BRICK_STAIRS, Material.POLISHED_BLACKSTONE_BRICK_SLAB, Material.CRACKED_POLISHED_BLACKSTONE_BRICKS,
            Material.CHAIN,
            Material.WARPED_FENCE, Material.WARPED_FENCE_GATE, Material.WARPED_BUTTON, Material.WARPED_DOOR, Material.WARPED_DOOR, Material.WARPED_FUNGUS, Material.WARPED_FUNGUS_ON_A_STICK, Material.WARPED_HYPHAE, Material.WARPED_NYLIUM, Material.WARPED_PLANKS, Material.WARPED_PRESSURE_PLATE, Material.WARPED_ROOTS, Material.WARPED_SIGN, Material.WARPED_WALL_SIGN, Material.WARPED_SLAB, Material.WARPED_STAIRS, Material.WARPED_STEM, Material.WARPED_TRAPDOOR, Material.WARPED_WART_BLOCK,
            Material.WEEPING_VINES, Material.WEEPING_VINES_PLANT,
            Material.WITHER_ROSE,
            Material.BONE_BLOCK,
            Material.CHISELED_NETHER_BRICKS, Material.NETHER_BRICK, Material.NETHER_BRICK_FENCE, Material.NETHER_BRICK_SLAB, Material.NETHER_BRICK_STAIRS, Material.NETHER_BRICK_WALL, Material.NETHER_BRICKS,
            Material.NETHER_GOLD_ORE, Material.NETHER_QUARTZ_ORE,
            Material.CHISELED_QUARTZ_BLOCK, Material.QUARTZ, Material.QUARTZ_BLOCK, Material.QUARTZ_BRICKS, Material.QUARTZ_PILLAR, Material.QUARTZ_SLAB, Material.QUARTZ_STAIRS,
            Material.CRACKED_NETHER_BRICKS,
            Material.CRIMSON_BUTTON, Material.CRIMSON_FENCE, Material.CRIMSON_FENCE_GATE, Material.CRIMSON_FUNGUS, Material.CRIMSON_HYPHAE, Material.CRIMSON_NYLIUM, Material.CRIMSON_PLANKS, Material.CRIMSON_PRESSURE_PLATE, Material.CRIMSON_ROOTS, Material.CRIMSON_SIGN, Material.CRIMSON_SLAB, Material.CRIMSON_STAIRS, Material.CRIMSON_STEM, Material.CRIMSON_TRAPDOOR, Material.CRIMSON_WALL_SIGN,
            Material.CRYING_OBSIDIAN,
            Material.MAGMA_BLOCK,
            Material.NETHER_SPROUTS, Material.NETHER_WART, Material.NETHER_WART_BLOCK,
            Material.NETHERRACK,
            Material.RED_NETHER_BRICK_SLAB, Material.RED_NETHER_BRICK_STAIRS, Material.RED_NETHER_BRICK_WALL, Material.RED_NETHER_BRICKS,
            Material.SHROOMLIGHT, Material.GLOWSTONE,
            Material.SMOOTH_QUARTZ, Material.SMOOTH_QUARTZ_SLAB, Material.SMOOTH_QUARTZ_STAIRS,
            Material.SOUL_SAND, Material.SOUL_SOIL,
            Material.STRIPPED_CRIMSON_STEM, Material.STRIPPED_CRIMSON_HYPHAE, Material.STRIPPED_WARPED_HYPHAE, Material.STRIPPED_WARPED_STEM);

    private List<ItemStack> rewardsList;

    private Random rand;

    private LuckOfTheNetherPickaxe luckOfTheNetherPickaxe;

    public LuckOfTheNetherListener(){
        luckOfTheNetherPickaxe = new LuckOfTheNetherPickaxe();
        rewardsList = new ArrayList<>();
        rand = new Random();

        ItemStack book1 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook1 = (EnchantmentStorageMeta) book1.getItemMeta();
        metaBook1.addStoredEnchant(Enchantment.PROTECTION_FIRE, 4, true);
        book1.setItemMeta(metaBook1);

        ItemStack book2 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook2 = (EnchantmentStorageMeta) book2.getItemMeta();
        metaBook2.addStoredEnchant(Enchantment.PROTECTION_FALL, 3, true);
        book2.setItemMeta(metaBook2);

        ItemStack book3 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook3 = (EnchantmentStorageMeta) book3.getItemMeta();
        metaBook3.addStoredEnchant(Enchantment.BINDING_CURSE, 1, true);
        book3.setItemMeta(metaBook3);

        ItemStack book4 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook4 = (EnchantmentStorageMeta) book4.getItemMeta();
        metaBook4.addStoredEnchant(Enchantment.FIRE_ASPECT, 1, true);
        book4.setItemMeta(metaBook4);

        ItemStack book5 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook5 = (EnchantmentStorageMeta) book5.getItemMeta();
        metaBook5.addStoredEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
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
        metaBook8.addStoredEnchant(Enchantment.DAMAGE_UNDEAD, 5, true);
        book8.setItemMeta(metaBook8);

        ItemStack book9 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook9 = (EnchantmentStorageMeta) book9.getItemMeta();
        metaBook9.addStoredEnchant(Enchantment.SILK_TOUCH, 1, true);
        book9.setItemMeta(metaBook9);

        ItemStack book10 = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta metaBook10 = (EnchantmentStorageMeta) book10.getItemMeta();
        metaBook10.addStoredEnchant(Enchantment.SOUL_SPEED, 1, true);
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

        rewardsList.add(new ItemStack(Material.ROTTEN_FLESH, 8));
        rewardsList.add(new ItemStack(Material.WITHER_ROSE, 1));
        rewardsList.add(new ItemStack(Material.WITHER_SKELETON_SKULL, 1));
        rewardsList.add(new ItemStack(Material.LODESTONE, 1));
        rewardsList.add(new ItemStack(Material.RESPAWN_ANCHOR, 1));
        rewardsList.add(new ItemStack(Material.GLOBE_BANNER_PATTERN, 1));
        rewardsList.add(new ItemStack(Material.MUSIC_DISC_PIGSTEP, 1));
        rewardsList.add(new ItemStack(Material.CAKE, 2));
        rewardsList.add(new ItemStack(Material.NETHER_STAR, 1));
        rewardsList.add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1));
        rewardsList.add(new ItemStack(Material.QUARTZ, 8));
        rewardsList.add(new ItemStack(Material.QUARTZ_BLOCK, 16));
        rewardsList.add(new ItemStack(Material.GOLD_INGOT, 4));
        rewardsList.add(new ItemStack(Material.GOLD_NUGGET, 8));
        rewardsList.add(new ItemStack(Material.GHAST_TEAR, 1));

    }

    @EventHandler
    public void luckyNetherListener(BlockBreakEvent e){
        if (e.getBlock().getWorld().getEnvironment() == World.Environment.NETHER){ //If the player is in the nether
            ItemStack tool = e.getPlayer().getInventory().getItemInMainHand();
            if (tool == null || tool.getItemMeta().getLore() == null){
                return;
            }
            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().equals(luckOfTheNetherPickaxe.getLoreAsListString())){
                if (MATERIAL_LIST.contains(e.getBlock().getBlockData().getMaterial())){ // If it is a end block

                    e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), rewardsList.get(rand.nextInt(rewardsList.size())));
                    return;
                }
            }
        }
        return;
    }
}
