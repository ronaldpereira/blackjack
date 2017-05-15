package jogador;

import java.util.ArrayList;

public class Dealer // Classe que representa o dealer
{
    private int valorMao = 0; // Guarda o valor da mao do jogador

    public void pegaCarta(int id, int valor) // Metodo que pega uma carta do baralho para o dealer
    {
        this.valorMao += valor;
    }

    public void descartaMao() // Metodo que descarta a mao do dealer ao final da rodada
    {
        this.valorMao = 0;
    }

    public int retornaValorMao() // Metodo que retorna o valor da mao atual do dealer
    {
        return this.valorMao;
    }
}
