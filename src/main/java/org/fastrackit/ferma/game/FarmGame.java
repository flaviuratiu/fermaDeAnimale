package org.fastrackit.ferma.game;

import org.fastrackit.ferma.domain.Animal;
import org.fastrackit.ferma.domain.Farm;
import org.fastrackit.ferma.domain.Ingrijitor;
import org.fastrackit.ferma.exception.ValidationException;

/**
 * @author ttritean
 * @since 4/8/2019
 */
public class FarmGame {

    public static void main(String args[]) {
        Farm myFarm = new Farm();

        Ingrijitor ion = new Ingrijitor(myFarm);

        Animal catel = null;

        try {
            catel = new Animal("catel", "labus");

        } catch (ValidationException ve) {
            //handling

            System.out.println("Am prins o exceptie: " + ve.getMessage());
        }

        try {
            Animal pisica = new Animal("pisica", "mata");
            ion.addAnimal(pisica);
            Animal oaie = new Animal("oai5e", "beee");
            ion.addAnimal(oaie);
        } catch (ValidationException ve) {
            System.out.println("Am prins o exceptie: " + ve.getMessage());
        }

        ion.addAnimal(catel);

        ion.feedAllAnimals("varza");
        ion.putAllAnimalsToSleep();

        try {
            Animal invalidAnimal = new Animal("animal5", "");
        } catch (ValidationException ve) {

            System.out.println("Invalid animal: "+ve.getMessage());

        }
    }
}
