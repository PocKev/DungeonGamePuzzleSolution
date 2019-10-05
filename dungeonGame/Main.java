/*
Dungeon Game Test
by Kevin Ge
*/

package dungeonGame;
import java.util.ArrayList;

public class Main {
    static int startHealth;
    static int[][] nodes = {
            {-2, -2, 8, -1, 1},
            {-8, 4, 0, -3, 2},
            { 1, 12, -4, -15, 4},
            {-3, -16, -7, 8, -20},
    };
    static ArrayList<Integer> minimums = new ArrayList<Integer>();

    public static void main(String[] args) {
        startHealth = 0;
        step(0, 0, startHealth, startHealth, "");
        answer();
    }

    public static void step(int posX, int posY, int health, int minHealth, String path) {
        path += "" + posX + "," + posY + " ";
        health += nodes[posY][posX];
        if (minHealth > health) {
            minHealth = health;
        }

        if (posX + 1 < nodes[posY].length) {
            step(posX + 1, posY, health, minHealth, path);
        }
        if (posY + 1 < nodes.length) {
            step(posX, posY + 1, health, minHealth, path);
        }
        if (posY == nodes.length - 1 && posX == nodes[posY].length - 1) {
            System.out.println("path: " + path + ", MinHealth: " + minHealth);
            minimums.add(minHealth);
        }
    }

    public static void answer() {
        int maximum = minimums.get(0);
        for (int i = 0; i < minimums.size(); i++) {
            if (minimums.get(i) > maximum) {
                maximum = minimums.get(i);
            }
        }
        System.out.println("Least Amount of Health: " + (1 - maximum));
    }
}

