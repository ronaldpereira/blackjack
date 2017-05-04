import java.util.ArrayList;
import java.util.Collections;

public class Blackjack
{
    public static void main(String[] args) throws Exception
    {
        MenuInterativo.apresentacao();
        MenuInterativo.interage();
        ArrayList<Baralho> baralho = CriaBaralho.criaeEmbaralhaBaralho();

        new JogaJogo(baralho);

        JogaJogo.teste();
    }
}
