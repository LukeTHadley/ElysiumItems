package com.github.lukethadley.elysiumitems;

import com.github.lukethadley.elysiumitems.items.CustomItem;
import com.github.lukethadley.elysiumitems.items.tools.ToolsHandler;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.*;

public class ToolsCommandHandler implements TabExecutor {

    private ToolsHandler items;
    private ElysiumItems plugin;

    private static final String[] subcommands = new String[]{"list", "give"};

    public ToolsCommandHandler(ElysiumItems plugin){
        this.plugin = plugin;
        items = new ToolsHandler();
        plugin.getLogger().info("Loaded " + items.getCustomItems().size() + " custom tools...");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0){ //No arguments given
            sender.sendMessage("You need to give arguments");
            return false;
        }
        if (args.length >= 1){ //Some arguments given
            if (command.getName().equals("elysiumtools")){ //It was the elysiumtools command
                if (args[0].equalsIgnoreCase("list")){ //It was the list command, list the items
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.LIST_ALL_TOOLS_HEADER));
                    for (CustomItem item : items.getCustomItems().values()) {
                        sender.sendMessage(item.getName() + ChatColor.GRAY + " - " + item.getDescription());
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ToolsMessages.LIST_ALL_TOOLS_FOOTER));
                    return true;
                }
                if (args[0].equalsIgnoreCase("give")) { //It was the give command
                    if (args.length >= 2){ //If there was an item given as an argument
                        if (items.checkExist(args[1])){ //Check that the given string corresponds to an item
                            CustomItem item = items.getCustomItems().get(args[1]); //Get the CustomItem object
                            if (args.length >= 3){ //If a specific player was specified
                                Player playerToGiveTo = plugin.getServer().getPlayer(args[2]);
                                if (playerToGiveTo != null){ //And the player exists
                                    playerToGiveTo.getInventory().addItem(item.getItem()); //Give to the player
                                    sender.sendMessage("You were given " + item.getName());
                                    plugin.getServer().getLogger().info(playerToGiveTo.getName() + " was given " + item.getName());
                                }
                                else { //If the player did not exist
                                    sender.sendMessage("That player does not exist!");
                                }
                            }
                            else {
                                if (sender instanceof Player){ //If a player wasn't specified, and the sender was a player, give it to that player
                                    Player p = (Player) sender;
                                    p.getInventory().addItem(item.getItem());
                                    sender.sendMessage("You were given " + item.getName());
                                }
                                else { //Console should not be given items, tell them off!
                                    sender.sendMessage("You must specify a player as console!");
                                }
                            }
                        }
                        else { //If the item doesn't exist
                            sender.sendMessage("That custom item does not exist");
                        }
                        return true;
                    }
                    else { //If the item was not specified
                        sender.sendMessage("Please specify a custom item");
                    }

                }
            }
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> suggestionList = new ArrayList<>();
        if (command.getName().equals("elysiumtools")){
            if (args.length == 1) {
                for (String subcommand : subcommands) {
                    if (subcommand.toLowerCase().startsWith(args[0].toLowerCase())) {
                        suggestionList.add(subcommand);
                    }
                }
                return suggestionList;
            }
            else if (args.length == 2){
                if (args[0].equalsIgnoreCase("list")){
                    return suggestionList;
                }
                for (CustomItem item : items.getCustomItems().values()) {
                    if (item.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
                        suggestionList.add(item.getName());
                    }
                }
                return suggestionList;
            }
            else if (args.length == 3){
                for (Player player : plugin.getServer().getOnlinePlayers()){
                    suggestionList.add(player.getName());
                }
            }
        }
        return suggestionList;
    }

}
