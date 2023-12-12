package edu.chenr.assign06;

import edu.chenr.assign04.ScreenBuffer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameState implements Loadable{
    private ScreenBuffer baseMap = new ScreenBuffer(12, 30, '.');
    private List<Loadable> items = new ArrayList<>();

    public Loadable createLoadable(String typeName) throws GameFileException {
        return switch (typeName) {
            case "Skeleton" -> new Skeleton();
            case "Rat" -> new Rat();
            case "Item" -> new Item();
            case "Tome" -> new Tome();
            default -> throw new GameFileException("Unknown type: " + typeName);
        };
    }

    public void load(Scanner input) throws GameFileException {
        baseMap.clear();

        int numberOfLines = input.nextInt();

        for (int i = 0; i < numberOfLines; i++) {
            String typeName = input.next();
            Loadable m = createLoadable(typeName);
            m.load(input);
            items.add(m);

            if (m instanceof Drawable) {
                Drawable drawable = (Drawable) m;
                drawable.draw(baseMap);
            }
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("MAP:\n");
        result.append(baseMap.getDisplayString()).append("\n");
        result.append("CREATURES:\n");

        for (Loadable c : items) {
            if (c instanceof Creature) {
                result.append("* ").append(c).append("\n");
            }
        }

        result.append("INVENTORY:\n");

        for (Loadable item : items) {
            if (item instanceof Item) {
                result.append("* ").append(item).append("\n");
            }
        }

        return result.toString();
    }

    public void save(String filename) throws GameFileException {
        try (PrintWriter writer = new PrintWriter(filename)){
            writer.print(this.toString());

        } catch (Exception e) {
            throw new GameFileException("Failed to save file!", e);
        }
    }
}
