package me.basil.core.enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class AutoSmeltingEnchantment extends Enchantment {
    public AutoSmeltingEnchantment(NamespacedKey key) {
        super(key);
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
