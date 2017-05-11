import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuInterativo
{
    private Jogador[] jogador;
    private int numJogadores = 7;
    private BufferedReader reader;

    public void apresentacao()
    {
        System.out.println("Bem-vindo ao JackBlack 2017/1");
        System.out.println("Autores: Marina Monteiro Moreira e Ronald Davi Rodrigues Pereira");
    }

    public void pegaNumJogadores() throws Exception
    {
        while(numJogadores > 6)
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
        jogador = new Jogador[numJogadores+1];
        for(int i = 1; i <= numJogadores; i++)
        {
            jogador[i] = new Jogador();
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

    public Jogador[] executaMenu() throws Exception
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
