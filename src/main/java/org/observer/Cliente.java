package org.observer;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer{
    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void cadastrar(Passagem passagem) {
        passagem.addObserver(this);
    }

    public void update(Observable passagem, Object arg1) {
        this.ultimaNotificacao = this.nome + ", O preço da passagem para o destino " + passagem.toString()+" sofreu uma redução!";
    }
}