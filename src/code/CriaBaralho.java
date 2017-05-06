import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CriaBaralho
{
    private int IDtopo = 0;

    public static ArrayList<Baralho> criaeEmbaralhaBaralho()
    {
        String nomedacarta;
        String naipedacarta;

        ArrayList<Baralho> baralho = new ArrayList<Baralho>();

        for(int deck = 1; deck <= 6; deck++)
        {
            for(int carta = 1; carta <= 13; carta++)
            {
                for(int naipe = 1; naipe <= 4; naipe++)
                {
                    if(naipe == 1)
                        naipedacarta = "Clubs";

                    else if(naipe == 2)
                        naipedacarta = "Hearts";

                    else if(naipe == 3)
                        naipedacarta = "Spades";

                    else
                        naipedacarta = "Diamonds";

                    if(carta == 1)
                        nomedacarta = "A";

                    else if(carta == 11)
                        nomedacarta = "J";

                    else if(carta == 12)
                        nomedacarta = "Q";

                    else if(carta == 13)
                        nomedacarta = "K";

                    else
                        nomedacarta = Integer.toString(carta);

                    Baralho card = new Baralho();
                    card.criaCarta(nomedacarta, naipedacarta);
                    baralho.add(card);
                }
            }
        }

        Random rng = new Random();
        int aux = rng.nextInt(10000);
        System.out.println(aux);

        for (int i = 0; i < aux; i++)
        {
            Collections.shuffle(baralho);
        }

        System.out.println(baralho.get(0).retornaNomeeNaipe());

        return baralho;
    }

    public void incrementaTopo()
    {
        this.IDtopo++;
    }
}
