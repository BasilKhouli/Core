package me.basil.core.listeners;

import me.basil.core.gui.FriendsGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;





public class FriendsGUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if (e.getInventory() != null && e.getCurrentItem() !=null && e.getView().getTitle().contains("Friends")) {
            int page = Integer.parseInt(e.getInventory().getItem(45).getItemMeta().getLocalizedName());

            System.out.println("RawSlot: " + e.getRawSlot() + ", ItemType: " + e.getCurrentItem().getType());



            if (e.getRawSlot() == 45 && e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE) || e.getRawSlot() == 46 && e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE) || e.getRawSlot() == 47 && e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE) || e.getRawSlot() == 48 && e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE)) {
                new FriendsGUI((Player) e.getWhoClicked(), page -1);
            } else if (e.getRawSlot() == 50 && e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE) || e.getRawSlot() == 51 && e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE) || e.getRawSlot() == 52 && e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE) || e.getRawSlot() == 53 && e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE)) {
                new FriendsGUI((Player) e.getWhoClicked(), page + 1);
            }


            e.setCancelled(true);

            }

        }

    }



