package menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuInterativo
{
    private jogador.Jogador[] jogador; // Vetor de jogadores
    private int numJogadores = 0; // Guarda o numero de jogadores
    private BufferedReader reader; // Leitor da entrada

    public void apresentacao()
    {
        System.out.println("Bem-vindo ao JackBlack 2017/1");
        System.out.println("Autores: Marina Monteiro Moreira e Ronald Davi Rodrigues Pereira");
    }

    public void pegaNumJogadores() throws Exception
    {
        while(numJogadores > 6 || numJogadores <= 0)
        {
            System.out.print("Insira o numero de jogadores (max. 6 jogadores): ");
            reader = new BufferedReader(new InputStreamReader(System.in));
            numJogadores = Integer.parseInt(reader.readLine());
        }

        this.criaJogadores(numJogadores);
        this.saldoInicial(numJogadores);
    }

    public void criaJogadores(int id) throws Exception
    {
        jogador = new jogador.Jogador[numJogadores+1];
        for(int i = 1; i <= numJogadores; i++)
        {
            jogador[i] = new jogador.Jogador();
            jogador[i].pegaNomeJogador(i);
        }
    }

    public void saldoInicial(int numJogadores) throws Exception
    {
        double valor = 0;
        while(valor < 10)
        {
            System.out.print("Insira o saldo inicial do(s) jogador(es) (min. de R$ 10.00): R$ ");
            reader = new BufferedReader(new InputStreamReader(System.in));
            valor = Double.parseDouble(reader.readLine());
        }

        for(int i = 1; i <= numJogadores; i++)
        {
            this.jogador[i].aumentaSaldo(valor);
        }
    }

    public jogador.Jogador[] executaMenu() throws Exception
    {
        this.apresentacao();
        this.pegaNumJogadores();

        return jogador;
    }

    public int retornaNumJogadores()
    {
        return this.numJogadores;
    }
}
