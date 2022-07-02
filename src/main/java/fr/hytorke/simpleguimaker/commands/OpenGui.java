package fr.hytorke.simpleguimaker.commands;

import fr.hytorke.simpleguimaker.SimpleGuiMaker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class OpenGui implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;

            //Verify if the GUI exist
            if (SimpleGuiMaker.guiName.contains(args[0])){
                //?
                return true;
            }

            player.sendMessage("§7The GUI doesn't exist or is wrongly spelt");
        }
        return true;
    }
}

//[#####################]
//[     By Hytorke      ]
//[#####################]
