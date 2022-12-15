package org.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Passagem passagem = new Passagem("Juiz de Fora", "Fortaleza");
        Cliente cliente = new Cliente("Wiliam Santos");
        cliente.cadastrar(passagem);
        passagem.lancarPassagem();
        assertEquals("Wiliam Santos, O preço da passagem para o destino Passagem{origem=Juiz de Fora, destino='Fortaleza'} sofreu uma redução!", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Passagem passagem = new Passagem("Juiz de Fora", "Fortaleza");
        Cliente cliente1 = new Cliente("Wiliam Santos");
        Cliente cliente2 = new Cliente("Igor José");
        cliente1.cadastrar(passagem);
        cliente2.cadastrar(passagem);
        passagem.lancarPassagem();
        assertEquals("Wiliam Santos, O preço da passagem para o destino Passagem{origem=Juiz de Fora, destino='Fortaleza'} sofreu uma redução!", cliente1.getUltimaNotificacao());
        assertEquals("Igor José, O preço da passagem para o destino Passagem{origem=Juiz de Fora, destino='Fortaleza'} sofreu uma redução!", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Passagem passagem = new Passagem("Juiz de Fora", "Fortaleza");
        Cliente cliente = new Cliente("Wiliam Santos");
        passagem.lancarPassagem();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteSaoPaulo() {
        Passagem passagemA = new Passagem("Juiz de Fora", "Sao Paulo");
        Passagem passagemB = new Passagem("Juiz de Fora", "Fortaleza");
        Cliente cliente1 = new Cliente("Wiliam Santos");
        Cliente cliente2 = new Cliente("Rodrigo Torres");
        cliente1.cadastrar(passagemA);
        cliente2.cadastrar(passagemB);
        passagemA.lancarPassagem();
        assertEquals("Wiliam Santos, O preço da passagem para o destino Passagem{origem=Juiz de Fora, destino='Sao Paulo'} sofreu uma redução!", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }

}