package jogador;

import java.util.ArrayList;

public class Dealer // Classe que representa o dealer
{
    private ArrayList<Integer> IDcartas = new ArrayList<Integer>(); // Array de inteiros para guardar os IDs das cartas da mao do dealer
    private int valorMao = 0; // Guarda o valor da mao do dealer
    private int numCartas = 0; // Guarda o numero de cartas na mao do dealer

    public void pegaCarta(int id, int valor) // Metodo que pega uma carta do baralho para o dealer
    {
        this.IDcartas.add(id);
        this.valorMao += valor;
        this.numCartas++;
    }

    public void descartaMao() // Metodo que descarta a mao do dealer ao final da rodada
    {
        this.IDcartas.clear();
        this.valorMao = 0;
        this.numCartas = 0;
    }
    
    public void imprimeMao(ArrayList<baralho.Baralho> baralho)
    {
        System.out.print("\nA mao do dealer e:\n");
        for(Integer carta : IDcartas)
            System.out.print(" | "+baralho.get(carta).retornaNomeeNaipe()+" | ");
        if(numCartas == 1)
            System.out.print(" | XX |");
        System.out.print("\n\n");
    }

    public int retornaValorMao() // Metodo que retorna o valor da mao atual do dealer
    {
        return this.valorMao;
    }
    
    public ArrayList<Integer> retornaIDcartas()
    {
        return this.IDcartas;
    }
    
    public int retornaNumCartas()
    {
        return this.numCartas;
    }
}
