/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab11;

/**
 * Created by sebadmin on 2015-10-05.
 */
public class KitchenTable {

    private String material;
    private int width;
    private int depth;
    private int height;

    /**
     * A Kitchentable object
     * @param material what its made of
     * @param width the width of the table
     * @param depth the depth of the table
     * @param height the height of the table
     */
    public KitchenTable(String material, int width, int depth, int height) {
        this.material = material;
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int size(){
        return this.depth*this.width;
    }

    @Override
    public String toString() {
        return "KitchenTable [" +
                "material='" + material + '\'' +
                ", width=" + width +
                ", depth=" + depth +
                ", height=" + height +
                ']';
    }
}
