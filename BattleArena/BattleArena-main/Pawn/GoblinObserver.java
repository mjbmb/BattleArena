package Pawn;

import java.util.LinkedList;
import java.util.Observable;

public class GoblinObserver {
    private int GoblinCount = 0;
    private LinkedList<Listener> Listeners = new LinkedList<Listener>();

    public GoblinObserver(LinkedList<Listener> Listeners){
        this.Listeners = Listeners;
    }

    public void update(Observable o, Object Array) {
        setGoblinCount((Integer) Array);
        if(GoblinCount == 5){
            sentInfo();
        }
        if(GoblinCount > 10){
            sentInfo();
        }
    }
    private void setGoblinCount(int GoblinCount){
        this.GoblinCount = GoblinCount;
    }
    private void sentInfo(){
        for(int i = 0; i<Listeners.size(); i ++){
            Listeners.get(i).setInfo("The Player has "+GoblinCount+" Goblins.");
        }
    }
}
