package me.basil.core.commands.utility;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;

            if (player.hasPermission("core.heal")) {

            player.setHealth(20);
            player.sendMessage(ChatColor.GREEN + "Health restored to full!");
            player.setFoodLevel(20);
            player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_BREAK, 1.0F, 1.0F);

            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            }
        }

        return false;
    }
}
