package fr.hytorke.simpleguimaker.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class setGuiOpenner implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player)sender;
            ItemStack itemInHand = player.getInventory().getItemInMainHand();

            if (itemInHand == null || itemInHand.getType() == Material.AIR) {
                player.sendMessage("§7Please hold and item in your principal hand");
                return true;
            }

            if (args[1].length() < 1 || args[2].length() < 1) {
                player.sendMessage("§7Please write the name of the gui correctly or create it with /creategui");
            }
            Inventory inv;
            ItemStack holdenItem = new ItemStack(itemInHand);
            ItemMeta meta = holdenItem.getItemMeta();
            meta.setDisplayName(args[0]);
            holdenItem.setItemMeta(meta);

            player.getInventory().setItemInMainHand(holdenItem);
        }
        return true;
    }
}
