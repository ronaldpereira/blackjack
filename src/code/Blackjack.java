import java.util.ArrayList;
import java.util.Collections;

public class Blackjack
{
    public static void main(String[] args)
    {
        ArrayList<Baralho> baralho = CriaBaralho.criaeEmbaralhaBaralho();

        System.out.println(baralho.get(0).valor+" "+baralho.get(0).naipe);

        baralho.remove(0);

        System.out.println(baralho.get(0).valor+" "+baralho.get(0).naipe);
    }
}
