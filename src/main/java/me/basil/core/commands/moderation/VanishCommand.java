package me.basil.core.commands.moderation;

import me.basil.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VanishCommand implements CommandExecutor {

    private final Main main;

    public VanishCommand(Main main) {
        this.main = main;
    }

    private List<UUID> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;
            if (player.hasPermission("core.vanish")) {

                if (vanished.contains(player.getUniqueId())) { //player is vanished (list contains their uuid)
                    vanished.remove(player.getUniqueId());
                    for (Player target : Bukkit.getOnlinePlayers()) {
                        target.showPlayer(main, player);
                    }
                    player.sendMessage(ChatColor.DARK_AQUA + "You are no-longer vanished!");

                } else { //player is not vanished

                    vanished.add(player.getUniqueId());
                    for (Player target : Bukkit.getOnlinePlayers()) {
                        target.hidePlayer(main, player);
                    }
                    player.sendMessage(ChatColor.DARK_AQUA + "You are now vanished!");

                }
            } else {

                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");

            }


        }

        return false;
    }
}
