package me.basil.core.commands.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ProfileGui implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player)  commandSender;

            Inventory profile = Bukkit.createInventory(player, 36, ChatColor.DARK_AQUA.toString() + ChatColor.BOLD + "Profile");




            player.openInventory(profile);
        }

        return false;
    }
}
