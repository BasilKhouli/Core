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
        Player player = (Player) e.getWhoClicked();

        if (e.getInventory() != null && e.getCurrentItem() != null && e.getView().getTitle().contains("Friends")) {
            int page = Integer.parseInt(e.getInventory().getItem(45).getItemMeta().getLocalizedName());

            //DEBUGGING: System.out.println("RawSlot: " + e.getRawSlot() + ", ItemType: " + e.getCurrentItem().getType());
            if (e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS_PANE)) {
                if (e.getRawSlot() >= 45 && e.getRawSlot() <= 48) {
                    new FriendsGUI((Player) e.getWhoClicked(), page - 1);
                } else if (e.getRawSlot() >= 50 && e.getRawSlot() <= 53) {
                    new FriendsGUI((Player) e.getWhoClicked(), page + 1);
                }

            }

            if (e.getRawSlot() == 8) {
                player.closeInventory();
            }

            e.setCancelled(true);

        }

    }

}