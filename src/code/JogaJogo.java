import java.util.ArrayList;

public class JogaJogo
{
    private Jogador[] jogador;
    private ArrayList<Baralho> baralho;
    private int numJogadores;

    JogaJogo(ArrayList<Baralho> baralho)
    {
        this.baralho = baralho;
    }

    public void jogada() throws Exception
    {
        MenuInterativo menu = new MenuInterativo();
        jogador = menu.executaMenu();
        numJogadores = menu.retornaNumJogadores();
        for(int i = 1; i <= numJogadores; i++)
            jogador[i].fazJogada();
    }
}
