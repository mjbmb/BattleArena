package Pawn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;

public class HealthObserver implements java.util.Observer {
    private int Health = 100;
    private LinkedList<Listener> Listeners = new LinkedList<Listener>();
    private int[][] TrackField;
    private String[] Achievments;

    private void initializeAchievments(){
        this.Achievments = new String[]{
                "",
                ""
        };
        this.TrackField = new int[Achievments.length][Listeners.size()];
        for(int i = 0; i<Achievments.length; i++){
            for(int d = 0; d< Listeners.size(); d++){
                if(d == 0){
                    TrackField[i][d] = i;
                }else {
                    TrackField[i][d] = 1;
                }
            }
        }
    }


    public HealthObserver(LinkedList<Listener> Listeners){
        this.Listeners = Listeners;
    }
    @Override
    public void update(Observable o, Object Array) {
        setHealth((Integer) Array);

        if(Health < 25){
            sentInfo(Achievments[0],0);
        }
    }


    private void setHealth(int Health){
        this.Health = Health;
    }
    private void sentInfo(String info, int index){
        for(int i = 0; i<Listeners.size(); i ++){
            TrackField[i][index+1] = 0;
            Listeners.get(i).setInfo(info);
        }
    }

}
