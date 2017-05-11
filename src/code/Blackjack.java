import java.util.ArrayList;
import java.util.Collections;

public class Blackjack
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Baralho> baralho;
        CriaBaralho criaBaralho = new CriaBaralho();
        baralho = criaBaralho.criaeEmbaralhaBaralho();

        JogaJogo jogajogo = new JogaJogo();
        jogajogo.atribuiBaralho(baralho);
        jogajogo.jogada();
    }
}
