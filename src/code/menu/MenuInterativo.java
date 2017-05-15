package menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuInterativo // Classe que representa o menu interativo do jogo
{
    private jogador.Jogador[] jogador; // Vetor de jogadores
    private int numJogadores = 0; // Guarda o numero de jogadores
    private BufferedReader reader; // Leitor da entrada

    public jogador.Jogador[] executaMenu() // Metodo que executa o MenuInterativo e retorna um vetor do tipo Jogador do pacote jogador
    throws Exception
    {
        this.apresentacao();
        this.pegaNumJogadores();

        return jogador;
    }

    public void apresentacao() // Metodo que realiza a apresentacao do jogo
    {
        
        System.out.println("\n\n\n  ━━━━━━━━━━━━━━━━");
        System.out.println("┃   Bem-vindo ao   ┃");
        System.out.println("┃ JackBlack 2017/1 ┃");
        System.out.println("  ━━━━━━━━━━━━━━━━");
        System.out.println("\n\nAutores: Marina Moreira e Ronald Pereira\n\n");
    }

    public void pegaNumJogadores() // Metodo que realiza a leitura de quantos jogadores vao jogar o jogo
    throws Exception
    {
        while(numJogadores > 6 || numJogadores <= 0)
        {
            System.out.print("Insira o numero de jogadores (max. 6 jogadores): ");
            reader = new BufferedReader(new InputStreamReader(System.in));
            numJogadores = Integer.parseInt(reader.readLine());
        }

        criaJogadores(numJogadores);
        saldoInicial(numJogadores);
    }

    private void criaJogadores(int id) // Metodo que realiza a criacao dos objetos dos jogadores, utilizando a classe Jogador do pacote jogador
    throws Exception
    {
        jogador = new jogador.Jogador[numJogadores+1];
        for(int i = 1; i <= numJogadores; i++)
        {
            jogador[i] = new jogador.Jogador();
            jogador[i].pegaNomeJogador(i);
        }
    }

    private void saldoInicial(int numJogadores) // Metodo que realiza a leitura do saldo inicial dos jogadores e coloca para cada jogador esse saldo
    throws Exception
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

    public int retornaNumJogadores() // Metodo que retorna o numero de jogadores
    {
        return this.numJogadores;
    }
}
