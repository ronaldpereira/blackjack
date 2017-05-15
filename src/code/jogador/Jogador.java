package jogador;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jogador // Classe que representa um jogador e todas as suas interacoes com o jogo
{
    private String nomeJogador; // String para guardar o nome do jogador
    private boolean isIA = false; // Flag para verificar se o jogador e uma inteligencia artificial
    private double saldo; // Guarda o saldo restante do jogador
    private double aposta = 0; // Guarda a aposta do jogador
    private int numDeA = 0; // Guarda o numero de As na mao do jogador
    private int valorMao = 0; // Guarda o valor da mao do jogador
    private int numCartas = 0; // Guarda o numero de cartas na mao do jogador
    private BufferedReader reader; // Leitor da entrada

    public void fazJogada(ArrayList<baralho.Baralho> baralho, int id) // Metodo que realiza a chamada para a jogada do jogador atual
    throws Exception
    {
        String option = "";

        System.out.print("\nVez de "+this.nomeJogador+"\n");

        while(!("stand".equals(option)) && !("double".equals(option)))
            option = jogo.JogaJogo.decisao(baralho, id);
    }

    public void fazAposta() // Metodo que realiza o recebimento da aposta do jogador atual
    throws Exception
    {
        if(this.saldo >= 10)
        {
            if(isIA)
            {
                System.out.format("\n%s, seu saldo atual e R$ %.2f", this.nomeJogador, this.saldo);
                System.out.print("\n"+this.nomeJogador+", qual a sua aposta? (min. R$ 10.00): R$ ");
                this.aposta = 10.0; // Se o jogador for uma IA, a aposta sempre sera minima
                System.out.format("%.2f\n", this.aposta);
            }

            else
            {
                while(this.aposta < 10 || this.aposta > this.saldo)
                {
                    System.out.format("\n%s, seu saldo atual e R$ %.2f", this.nomeJogador, this.saldo);
                    System.out.print("\n"+this.nomeJogador+", qual a sua aposta? (min. R$ 10.00): R$ ");
                    reader = new BufferedReader(new InputStreamReader(System.in));
                    this.aposta = Double.parseDouble(reader.readLine());
                }
            }
            diminuiSaldo(aposta); // Metodo que realiza a deducao da aposta do saldo do jogador atual
        }

        else
            System.out.print("\n"+this.nomeJogador+", seu saldo e insuficiente.\nSaldo atual e R$ "+this.saldo+"\n\n");
    }

    public void pegaNomeJogador(int id) // Metodo que realiza a atribuicao do nome do jogador atual
    throws Exception
    {
        System.out.print("Insira o nome do jogador "+id+" : ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String nome = reader.readLine();

        if("IA".equals(nome))
        {
            this.nomeJogador = "Inteligencia Artificial (Jogador "+id+")";
            this.isIA = true;
        }

        else
        this.nomeJogador = nome;
    }

    public void aumentaSaldo(double valor) // Metodo que realiza o aumento do saldo do jogador
    {
        this.saldo += valor;
    }

    public void diminuiSaldo(double valor) // Metodo que realiza a deducao do saldo do jogador
    {
        this.saldo -= valor;
    }

    public void daDouble() // Metodo que realiza a deducao do saldo e dobra a aposta, caso o jogador escolha dar double
    {
        this.saldo -= this.aposta;
        this.aposta *= 2;
    }

    public boolean verificaDouble() // Metodo que realiza a verificacao se o saldo do jogador e suficiente para dar double
    {
        return (this.retornaSaldo() >= this.retornaAposta());
    }

    public void estourouMao() // Metodo que realiza a atribuicao, de forma que, se o jogador estourou a sua mao, ele deve ter uma soma menor que a do dealer
    {
        this.valorMao = -1;
    }

    public void pegaCarta(int id, int valor) // Metodo que realiza atribuicao do valor da carta ao jogador, tratando o valor duplo da carta A
    {
        numCartas++;
        if(valor == 11)
        {
            this.valorMao += valor;
            this.numDeA++;
        }
        else
            this.valorMao += valor;

        if(this.valorMao > 21 && numDeA > 0)
        {
            this.valorMao -= numDeA * 10;
            numDeA = 0;
        }
    }

    public void descartaMao() // Metodo que realiza o descarte da mao atual do jogador
    {
        this.valorMao = 0;
        this.numCartas = 0;
        this.numDeA = 0;
        this.aposta = 0;
    }

    public String retornaNomeJogador() // Metodo que realiza o retorno do nome do jogador
    {
        return this.nomeJogador;
    }

    public double retornaSaldo() // Metodo que realiza o retorno do saldo do jogador
    {
        return this.saldo;
    }

    public double retornaAposta() // Metodo que realiza o retorno da aposta atual do jogador
    {
        return this.aposta;
    }

    public int retornaValorMao() // Metodo que realiza o retorno do valor atual da mao do jogador
    {
        return this.valorMao;
    }

    public int retornaNumCartas() // Metodo que realiza o retorno do numero de cartas na mao do jogador
    {
        return this.numCartas;
    }

    public boolean retornaIsIA() // Metodo que realiza o retorno da flag para verificar se um jogador e uma IA ou jogador fisico
    {
        return this.isIA;
    }
}
