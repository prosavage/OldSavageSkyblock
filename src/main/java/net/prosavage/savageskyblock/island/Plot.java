package net.prosavage.savageskyblock.island;

public class Plot {

    int plotX;
    int plotY;

    public Plot(int plotX, int plotY) {
        this.plotX = plotX;
        this.plotY = plotY;
    }

    public int getX() {
        return plotX;
    }

    public int getY() {
        return plotY;
    }

    public String toString() { return "X: " + getX() + ", Y: " + getY(); }


}
