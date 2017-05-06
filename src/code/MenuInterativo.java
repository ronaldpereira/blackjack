import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuInterativo
{
    private Jogador[] jogador;
    private int numJogadores;
    private BufferedReader reader;

    public void apresentacao()
    {
        System.out.println("Bem-vindo ao JackBlackJack 2017/2");
        System.out.println("Autores: Marina Monteiro Moreira e Ronald Davi Rodrigues Pereira");
    }

    public void interage() throws Exception
    {
        pegaNumJogadores();
    }

    public void pegaNumJogadores() throws Exception
    {
        System.out.print("Insira o numero de jogadores: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        numJogadores = Integer.parseInt(reader.readLine());

        this.criaJogadores(numJogadores);
        this.saldoInicial(numJogadores);

        for (int i = 1; i <= numJogadores; i++) // TODO print de nome dos jogadores teste
            System.out.println("Nome do jogador "+i+" é "+this.jogador[i].retornaNomeJogador());
    }

    public void criaJogadores(int id) throws Exception
    {
        jogador = new Jogador[numJogadores+1];
        for(int i = 1; i <= numJogadores; i++)
        {
            jogador[i] = new Jogador();
            jogador[i].pegaNomeJogador(i);
        }
    }

    public void saldoInicial(int numJogadores) throws Exception
    {
        System.out.print("Insira o saldo inicial do(s) jogador(es): R$ ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        double valor = Double.parseDouble(reader.readLine());

        for(int i = 1; i <= numJogadores; i++)
        {
            this.jogador[i].aumentaSaldo(valor);
        }
    }

    public void executaMenu() throws Exception
    {
        this.apresentacao();
        this.interage();
    }

}
