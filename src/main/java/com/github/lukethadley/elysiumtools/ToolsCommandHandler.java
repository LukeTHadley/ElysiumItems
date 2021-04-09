package com.github.lukethadley.elysiumtools;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class ToolsCommandHandler implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equals("elysiumtools")){
            if (args[0].toLowerCase().equals("list")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.LIST_ALL_TOOLS_HEADER));
                for (Tools tool : Tools.values()){
                    sender.sendMessage(tool.getName() + ChatColor.GRAY + " - " + tool.getDescription());
                }
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.LIST_ALL_TOOLS_FOOTER));
            }
            if (args.length == 1){
                for (Tools tool : Tools.values()){
                    if (tool.name().equals(args[0])){
                        ItemStack stack = new ItemStack(tool.getItemType(), 1);
                        ItemMeta meta = stack.getItemMeta();
                        meta.setDisplayName(tool.getName());
                        meta.setLore(Arrays.asList(tool.getLore()));



                        for (Enchantment value : tool.getEnchantments().keySet()){
                            meta.addEnchant(value, tool.getEnchantments().get(value), true);
                        }
                        if (!tool.isShowEnchantments()) { meta.addItemFlags(ItemFlag.HIDE_ENCHANTS); }



                        stack.setItemMeta(meta);
                        Player p = (Player) sender;
                        p.getInventory().addItem(stack);

                    }
                }
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> suggestionList = new ArrayList<>();

        if (command.getName().equals("elysiumtools")){
            if (args.length == 1){
                for (Tools tool : Tools.values()){
                    if (tool.name().toLowerCase().startsWith(args[0].toLowerCase())){
                        suggestionList.add(tool.name());
                    }
                }
            }
        }

        return suggestionList;
    }
}
