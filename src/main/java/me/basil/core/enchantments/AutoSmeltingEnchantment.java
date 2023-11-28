package me.basil.core.enchantments;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class AutoSmeltingEnchantment extends Enchantment implements Listener {
    public AutoSmeltingEnchantment(NamespacedKey key) {
        super(NamespacedKey.minecraft("auto_smelting"));
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        if (!e.isDropItems()) return;
        if (e.getPlayer().getInventory().getItemInMainHand() == null) return;
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(this)) return;

        e.setDropItems(false);
        // e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation())
        //Set up ore list and reference it here

    }

    @Override
    public String getName() {
        return "Auto Smelting";
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.TOOL;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment) {
        return enchantment.equals(Enchantment.SILK_TOUCH);
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        return itemStack.getType().toString().endsWith("_PICKAXE");
    }
}
