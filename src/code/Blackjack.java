import java.util.ArrayList;
import java.util.Collections;

public class Blackjack
{
    public static void main(String[] args) throws Exception
    {
        MenuInterativo menu = new MenuInterativo();
        menu.executaMenu();

        ArrayList<Baralho> baralho = CriaBaralho.criaeEmbaralhaBaralho();

        JogaJogo jogajogo = new JogaJogo(baralho);
    }
}
