package org.fastrackit.ferma.game;

import org.fastrackit.ferma.domain.Animal;
import org.fastrackit.ferma.domain.Farm;
import org.fastrackit.ferma.domain.Ingrijitor;

/**
 * @author ttritean
 * @since 4/8/2019
 */
public class FarmGame {

    public static void main(String args[]) {


        Animal catel = new Animal("catel","labus");
        Animal pisica = new Animal("pisica","mata");
        Animal oaie = new Animal("oaie","beee");

        Farm myFarm = new Farm();

        Ingrijitor ion = new Ingrijitor(myFarm);

        ion.addAnimal(catel);
        ion.addAnimal(pisica);
        ion.addAnimal(oaie);


        ion.feedAllAnimals("varza");
        ion.putAllAnimalsToSleep();



    }
}
