import java.util.ArrayList;
import java.util.Collections;

public class Blackjack
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Baralho> baralho = CriaBaralho.criaeEmbaralhaBaralho();

        JogaJogo jogajogo = new JogaJogo(baralho);
        jogajogo.jogada();
    }
}
