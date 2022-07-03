package fr.hytorke.simpleguimaker.commands;

import fr.hytorke.simpleguimaker.SimpleGuiMaker;
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

        //Catch the Gui size and name
        try {
            inventorySize = Integer.parseInt(args[0]);
        } catch (NumberFormatException ignored) {};

        if (inventorySize < 1 || inventorySize > 6) {
            player.sendMessage("§7Please put a number between 1 and 6");
            return false;
        }

        stringBuilder = new StringBuilder(args[1]);
        for (int i = 2; i < args.length; i++) {
            stringBuilder.append(' ');
            stringBuilder.append(args[i]);
        }
        inventoryName = ChatColor.translateAlternateColorCodes('&', stringBuilder.toString());

        if (SimpleGuiMaker.guiName.contains(name)) {
            player.sendMessage("§7The Gui already exist or is named same");
            return false;
        }

        // Here, InvName & Length are defined

        Map<Object, Object> Guisave = new HashMap<>();

        return true;
    }
}

//[#####################]
//[     By Hytorke      ]
//[#####################]