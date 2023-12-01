package me.basil.core.gui;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ProfileGUI {

    public ProfileGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 54, "Profile");

        // PROFILE IMAGE
        ItemStack profileImage = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta profileImageMeta = profileImage.getItemMeta();
        profileImageMeta.setDisplayName(ChatColor.DARK_PURPLE + "Profile Image");
        profileImage.setItemMeta(profileImageMeta);
        for (int i : new int[]{9,10,11,12,13,18,19,20,21,22,27,28,29,30,31,36,37,38,39,40}) {
            gui.setItem(i, profileImage);
        }

        // RANK
        ItemStack rank = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta rankMeta = rank.getItemMeta();
        rankMeta.setDisplayName(ChatColor.RED + "Rank");
        rank.setItemMeta(rankMeta);

        gui.setItem(14, rank);
        gui.setItem(15, rank);
        gui.setItem(16, rank);
        gui.setItem(17, rank);

        // RACE

        ItemStack race = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta raceMeta = race.getItemMeta();
        raceMeta.setDisplayName(ChatColor.BLUE + "Race");
        race.setItemMeta(raceMeta);

        gui.setItem(23, race);
        gui.setItem(24, race);
        gui.setItem(25, race);
        gui.setItem(26, race);


        // CLASSES

        ItemStack classes = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta classesMeta = classes.getItemMeta();
        classesMeta.setDisplayName(ChatColor.GREEN + "Class");
        classes.setItemMeta(classesMeta);

        gui.setItem(32, classes);
        gui.setItem(33, classes);
        gui.setItem(34, classes);
        gui.setItem(35, classes);


        // SETTINGS

        ItemStack settings = new ItemStack(Material.GLASS_PANE);
        ItemMeta settingsMeta = settings.getItemMeta();
        settingsMeta.setDisplayName(ChatColor.DARK_GRAY + "Settings");
        settings.setItemMeta(settingsMeta);

        gui.setItem(41, settings);
        gui.setItem(42, settings);
        gui.setItem(43, settings);
        gui.setItem(44, settings);



        player.openInventory(gui);
    }

}
