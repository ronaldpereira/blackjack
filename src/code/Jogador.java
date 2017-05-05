import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jogador
{
    private ArrayList<Integer> IDcartas;
    private String nomeJogador;
    private double saldo;
    private BufferedReader reader;

    public void saldoInicial() throws Exception
    {
        System.out.print("Insira o saldo inicial do(s) jogador(es): R$ ");
        reader = new BufferedReader(new InputStreamReader(System.in));

        saldo = Double.parseDouble(reader.readLine());

        System.out.println("Saldo inicial: R$"+saldo);
    }

    public void pegaNomeJogador(int id) throws Exception
    {
        System.out.print("Insira o nome do jogador "+id+" : ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.nomeJogador = reader.readLine();
    }

    public String retornaNomeJogador()
    {
        return this.nomeJogador;
    }
}
