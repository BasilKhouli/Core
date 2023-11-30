package me.basil.core.gui;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ProfileGUI {

    public ProfileGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 54, "Profile");




        player.openInventory(gui);
    }

}
