import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jogador
{
    private ArrayList<Integer> IDcartas;
    private double saldo;

    public void saldoInicial() throws Exception
    {
        System.out.println("Insira o saldo inicial do(s) jogador(es): R$ ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        saldo = Double.parseDouble(reader.readLine());
    }
}
