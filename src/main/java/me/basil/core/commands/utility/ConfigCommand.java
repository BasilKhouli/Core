package me.basil.core.commands.utility;

import me.basil.core.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ConfigCommand implements CommandExecutor {

    private Main main;

    public ConfigCommand(Main main){

        this.main = main;

    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;

            main.getConfig().set("Word", "Cake");
            List<String> list = main.getConfig().getStringList("String-list");
            list.add("New value");
            main.getConfig().set("String-list", list);

            main.saveConfig();

        }


        return false;
    }
}
