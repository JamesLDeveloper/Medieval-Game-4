package ArmourFiles.TestArmour;

import ArmourFiles.Armour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmourTest {

    @Test
    public void reduceDurabilityTest(){
        Armour platedArmour = new Armour("Plated Armour", 10, 5);

     platedArmour.reduceDurability(15);

     assertEquals(0, platedArmour.getDurability());


    }


}