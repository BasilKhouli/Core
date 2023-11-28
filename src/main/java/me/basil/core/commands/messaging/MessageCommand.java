package me.basil.core.commands.messaging;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {

    //          /message <player> <message>

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;

            if (args.length == 2) {

            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage! Use: /message <player> <message>.");
            }

        }

        return false;
    }
}
