import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuInterativo
{
    Jogador[] jogador;
    private int numJogadores;
    BufferedReader reader;

    public void apresentacao()
    {
        System.out.println("Bem-vindo ao JackBlack 2017/2");
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

        criaJogadores(numJogadores);

        for (int i = 1; i <= numJogadores; i++)
            System.out.println(this.jogador[i].retornaNomeJogador());
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

    public void executaMenu() throws Exception
    {
        this.apresentacao();
        this.interage();
    }

}
