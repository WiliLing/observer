package org.observer;
import java.util.Observable;

public class Passagem extends Observable {


    private String origem;
    private String destino;

    public Passagem(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public void lancarPassagem() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Passagem{" +
                "origem=" + origem +
                ", destino='" + destino + '\'' +
                '}';
    }
}