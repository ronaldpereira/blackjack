import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jogador
{
    private ArrayList<Integer> IDcartas;
    private String nomeJogador;
    private boolean isIA = false; // Flag para verificar se o jogador e uma inteligencia artificial
    private double saldo;
    private BufferedReader reader;

    public void aumentaSaldo(double valor)
    {
        this.saldo += valor;
    }

    public void diminuiSaldo(double valor)
    {
        this.saldo -= valor;
    }

    public void pegaCarta(int id)
    {
        this.IDcartas.add(id);
    }

    public void descartaMao()
    {
        this.IDcartas.clear();
    }

    public void pegaNomeJogador(int id) throws Exception
    {
        System.out.print("Insira o nome do jogador "+id+" : ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String nome = reader.readLine();

        if("IA".equals(nome))
        {
            this.nomeJogador = "Inteligencia Artificial "+id;
            this.isIA = true;
        }

        else
            this.nomeJogador = nome;
    }

    public String retornaNomeJogador()
    {
        return this.nomeJogador;
    }

    public double retornaSaldo()
    {
        return this.saldo;
    }

    public ArrayList<Integer> retornaIDcartas()
    {
        return this.IDcartas;
    }
}
