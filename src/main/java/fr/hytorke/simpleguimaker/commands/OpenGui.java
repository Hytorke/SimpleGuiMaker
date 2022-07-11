package fr.hytorke.simpleguimaker.commands;

import fr.hytorke.simpleguimaker.SimpleGuiMaker;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Map;

public class OpenGui implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            StringBuilder stringBuilder;
            String inventoryName;

            stringBuilder = new StringBuilder(args[0]);
            for (int i = 1; i < args.length; i++) {
                stringBuilder.append(' ');
                stringBuilder.append(args[i]);
            }

            inventoryName = stringBuilder.toString();

            //Verify if the GUI exist
            if (!CreateGui.basicGui.containsKey(inventoryName)){
                player.sendMessage("The GUI " + args[0] + " not exist or wrongly spelt");
                return true;
            }

            Inventory inventory = Bukkit.createInventory(null, CreateGui.basicGui.get(inventoryName) , inventoryName);

            player.openInventory(inventory);
        }
        return true;
    }
}

//[#####################]
//[     By Hytorke      ]
//[#####################]
