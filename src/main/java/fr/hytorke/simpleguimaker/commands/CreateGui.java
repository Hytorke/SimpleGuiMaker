package fr.hytorke.simpleguimaker.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateGui implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        int inventorySize = -1;
        StringBuilder stringBuilder;
        String inventoryName;

        if (!(sender instanceof Player)) {
            sender.sendMessage("Please be player to send this command");
            return false;
        }
        player = (Player) sender;

        if(args.length < 1) {
            player.sendMessage("§aPlease type de command well (/simpleguihelp)");
            return true;
        }

        //Catch the Gui size and name
        try {
            inventorySize = Integer.parseInt(args[0]);
        } catch (NumberFormatException ignored) {};

        if (inventorySize < 1 || inventorySize > 6) {
            player.sendMessage("§aPlease put a number between §e§l1 §aand §e§l6 §a instead of \"§e§l" + args[0] + "§a\"");
            return false;
        }

        stringBuilder = new StringBuilder(args[1]);
        for (int i = 2; i < args.length; i++) {
            stringBuilder.append(' ');
            stringBuilder.append(args[i]);
        }
        inventoryName = ChatColor.translateAlternateColorCodes('&', stringBuilder.toString());

        if (basicGui.containsKey(inventoryName)) {
            player.sendMessage("§aThe Gui \"§e§l" + inventoryName + "§a\" already exist or is named same");
            return false;
        }

        basicGui.put(inventoryName, inventorySize);
        player.sendMessage("§aThe GUI \"§e§l" + inventoryName + "§a\" has successfully been created with §e" + basicGui.get(inventoryName) + " §ainventory line") ;
        return true;
    }
    public static Map<String, Integer> basicGui = new HashMap<>();

}

//[#####################]
//[     By Hytorke      ]
//[#####################]