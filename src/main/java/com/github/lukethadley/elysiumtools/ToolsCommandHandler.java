package com.github.lukethadley.elysiumtools;

import com.github.lukethadley.elysiumtools.items.CustomToolInterface;
import com.github.lukethadley.elysiumtools.items.ItemHandler;
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

    private ItemHandler items;

    public ToolsCommandHandler(){
        items = new ItemHandler();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("elysiumtools")){
            if (args[0].equalsIgnoreCase("list")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.LIST_ALL_TOOLS_HEADER));

                for (CustomToolInterface item : items.getCustomItems().values()) {
                    sender.sendMessage(item.getName() + ChatColor.GRAY + " - " + item.getDescription());
                }
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.LIST_ALL_TOOLS_FOOTER));
            }
            if (args.length == 1){
                if (items.checkExist(args[0])){
                    Player p = (Player) sender;
                    p.getInventory().addItem(items.getCustomItems().get(args[0]).getItem());
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> suggestionList = new ArrayList<>();
        if (command.getName().equals("elysiumtools")){
            if (args.length == 1) {
                for (CustomToolInterface item : items.getCustomItems().values()) {
                    if (item.getName().toLowerCase().startsWith(args[0].toLowerCase())) {
                        suggestionList.add(item.getName());
                    }
                }
            }
        }
        return suggestionList;
    }

}
