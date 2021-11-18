package Pawn;

import java.util.LinkedList;
import java.util.Observable;

public class CoinObserver {
    private int Coin = 0;
    private LinkedList<Listener> Listeners = new LinkedList<Listener>();

    public CoinObserver(LinkedList<Listener> Listeners){
        this.Listeners = Listeners;
    }

    public void update(Observable o, Object Array) {
        setCoin((Integer) Array);
        if(Coin == 5){
            sentInfo();
        }
        if(Coin == 10){
            sentInfo();
        }
    }
    private void setCoin(int Coin){
        this.Coin = Coin;
    }
    private void sentInfo(){
        for(int i = 0; i<Listeners.size(); i ++){
            Listeners.get(i).setInfo("The Player has "+Coin+" Coins.");
        }
    }
}
