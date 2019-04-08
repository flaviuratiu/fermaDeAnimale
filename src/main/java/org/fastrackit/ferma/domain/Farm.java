package org.fastrackit.ferma.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ttritean
 * @since 4/8/2019
 */
public class Farm {


    private List<Animal> animals = new ArrayList<Animal>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
