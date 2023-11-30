package me.basil.core.commands.gui;

import me.basil.core.gui.FriendsGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FriendsGUICommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            new FriendsGUI((Player) commandSender, 1);
        }


        return false;
    }
}
