import java.util.ArrayList;
import java.util.Collections;

public class Blackjack
{
    public static void main(String[] args)
    {
        ArrayList<Baralho> baralho = CriaBaralho.criaeEmbaralhaBaralho();

        new JogaJogo(baralho);
    }
}
