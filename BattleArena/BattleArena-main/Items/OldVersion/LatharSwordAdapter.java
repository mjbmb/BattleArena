package Items.OldVersion;

import Items.IEquipment;
import Items.OldVersion.LatharSword;
import Pawn.Hero;

import java.util.Random;

public class LatharSwordAdapter implements IEquipment {
    private LatharSword sword = new LatharSword(new Random());;


    @Override
    public String getName(){
        return "Lathar Sword";
    }
    @Override
    public void use(Hero other) {
        other.reduceHealth(sword.hit());
    }

}

