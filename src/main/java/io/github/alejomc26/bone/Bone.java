package io.github.alejomc26.bone;

import org.bukkit.Location;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Represents a bone, you can put custom model data in it and make a 3D model
 */
public class Bone {

    private final ItemDisplay display;
    public Bone(Location location) {
        this.display = location.getWorld().spawn(location, ItemDisplay.class, (display) -> display.setTeleportDuration(2));
    }

    /**
     * Gets the ItemDisplay that the BoneBuilder uses
     * @return BoneBuilder display
     */
    public ItemDisplay getDisplay() {
        return this.display;
    }

    /**
     * Gets a copy of the current location of the BoneBuilder
     * @return BoneBuilder location
     */
    public Location getLocation() {
        return this.display.getLocation();
    }

    /**
     * Sets BoneBuilder data to display a 3D model
     * @param itemStack ItemStack used as a base item
     * @param customModelData CustomModelData that the texture pack assigned for the texture
     */
    public void setModel(ItemStack itemStack, int customModelData) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.setCustomModelData(customModelData);

        itemStack.setItemMeta(meta);
        this.display.setItemStack(itemStack);
    }

    /**
     * Teleport the BoneBuilder to the given location
     * @param location Teleport location
     */
    public void teleport(Location location) {
        this.display.teleport(location);
    }

    /**
     * Remove the BoneBuilder
     */
    public void remove() {
        this.display.remove();
    }
}