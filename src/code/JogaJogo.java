import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JogaJogo
{
    private Jogador[] jogador;
    private ArrayList<Baralho> baralho;
    private int numJogadores;
    private static BufferedReader reader;
    private static String option;

    public void atribuiBaralho(ArrayList<Baralho> baralho)
    {
        this.baralho = baralho;
    }

    public void jogada() throws Exception
    {
        MenuInterativo menu = new MenuInterativo();
        jogador = menu.executaMenu();
        numJogadores = menu.retornaNumJogadores();

        for(int i = 1; i <= numJogadores; i++)
            jogador[i].fazJogada(i);
    }

    public String decisao(int id) throws Exception
    {
        reader = new BufferedReader(new InputStreamReader(System.in));
        option = reader.readLine();

        if("hit".equals(option))
        {
            System.out.println("Entrou no hit");
            distribuiCartas(id);
        }

        else if("stand".equals(option))
        {
            System.out.println("Entrou no stand");
        }

        else if("double".equals(option))
        {

        }

        else if("split".equals(option))
        {

        }

        return option;
    }

    public void distribuiCartas(int id)
    {
        for(int i = 0; ; i++)
        {
            if(!(this.baralho.get(i).retornaUso())) // Carta nao esta na mesa
            {
                this.baralho.get(i).cartaPuxada();
                this.jogador[id].pegaCarta(i);
                return;
            }
        }
    }
}
