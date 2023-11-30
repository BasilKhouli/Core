package me.basil.core.gui;

import me.basil.core.utils.GUIPageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FriendsGUI {

    public FriendsGUI(Player player, int page) {
        Inventory gui = Bukkit.createInventory(null, 54, "Friends - " + page);


        List<ItemStack> friends = new ArrayList<>();
        for (int i = 0; i < 135; i++) {
            friends.add(new ItemStack(Material.PLAYER_HEAD));
        }


        ItemStack left;
        ItemMeta leftMeta;
        if (GUIPageUtil.isGUIPageValid(friends, page - 1, 36)) {
            left = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            leftMeta = left.getItemMeta();
            leftMeta.setDisplayName(ChatColor.GREEN + "Back");
        } else {
            left = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            leftMeta = left.getItemMeta();
            leftMeta.setDisplayName(ChatColor.RED + "Back");
        }
        leftMeta.setLocalizedName(page + "");
        left.setItemMeta(leftMeta);

        gui.setItem(45, left);
        gui.setItem(46, left);
        gui.setItem(47, left);
        gui.setItem(48, left);

        ItemStack right;
        ItemMeta rightMeta;
        if (GUIPageUtil.isGUIPageValid(friends, page + 1, 36)) {
            right = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            rightMeta = right.getItemMeta();
            rightMeta.setDisplayName(ChatColor.GREEN + "Next");
        } else {
            right = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            rightMeta = right.getItemMeta();
            rightMeta.setDisplayName(ChatColor.RED + "Next");
        }
        rightMeta.setLocalizedName(page + "");
        right.setItemMeta(rightMeta);

        gui.setItem(50, right);
        gui.setItem(51, right);
        gui.setItem(52, right);
        gui.setItem(53, right);


        int spacer = 9;
        for (ItemStack is : GUIPageUtil.getPageItems(friends, page, 36)) {
            gui.setItem(spacer, is);
            spacer++;
        }


        player.openInventory(gui);

    }
}