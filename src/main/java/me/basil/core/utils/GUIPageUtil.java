package me.basil.core.utils;

import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import java.util.List;

public class GUIPageUtil {

    public static List<ItemStack> getPageItems(List<ItemStack> items, int page, int spaces){

        int upperBound = page * spaces;
        int lowerBound = upperBound - spaces;

        List<ItemStack> newItems = new ArrayList<>();
        for (int  i = lowerBound; i < upperBound; i++) {

            try {
                newItems.add(items.get(i));
            } catch (IndexOutOfBoundsException x) {
                break;
            }
        }

        return newItems;

    }

    public static boolean isGUIPageValid(List<ItemStack> items, int page, int spaces){

        if (page <= 0) {
            return false;
        }

        int upperBound = page * spaces;
        int lowerBound = upperBound - spaces;

        return items.size() > lowerBound;



    }


}
