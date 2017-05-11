import javafx.scene.paint.Color;

import java.util.List;

public class Dandelion extends Plant {
    Dandelion(MyField[][] fields, List<Organism> organisms) {
        super(fields, Organisms.DANDELION.strength, Organisms.DANDELION.initiation, Organisms.DANDELION.color, Organisms.DANDELION.name, organisms);
    }

    Dandelion(MyField[][] fields, List<Organism> organisms, int posX, int posY) {
        super(fields, 0, 0, Color.YELLOW, "Dandelion", organisms, posX, posY);
    }

    @Override
    void action() {
        for (int i = 0; i < 3; i++) {
            if (generator.nextInt(20) == 0) {
                MyField childField = getEmptyNearbyFieldForSpreadingPlant();
                if (childField != null) {
                    organisms.add(new Dandelion(fields, organisms, childField.getY(), childField.getX()));
                    announcements += (name + " spreads over\n");
                }
            }
        }
    }

    @Override
    int reflectedAttack(Organism opponent) {
        return 0;
    }
}