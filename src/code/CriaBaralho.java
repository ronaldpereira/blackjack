import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CriaBaralho
{
    private int IDtopo = 0;
    private ArrayList<Baralho> baralho;

    public ArrayList<Baralho> criaeEmbaralhaBaralho()
    {
        String nomedacarta;
        String naipedacarta;

        this.baralho = new ArrayList<Baralho>();

        for(int deck = 1; deck <= 6; deck++)
        {
            for(int carta = 1; carta <= 13; carta++)
            {
                for(int naipe = 1; naipe <= 4; naipe++)
                {
                    if(naipe == 1)
                        naipedacarta = "Paus";

                    else if(naipe == 2)
                        naipedacarta = "Copas";

                    else if(naipe == 3)
                        naipedacarta = "Espadas";

                    else
                        naipedacarta = "Ouros";

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

        this.embaralhaBaralho();

        return this.baralho;
    }

    private void embaralhaBaralho()
    {
        Random rng = new Random();
        int aux = rng.nextInt(10000); // Gera um inteiro randomico entre 0 e 10000

        for (int i = 0; i < aux; i++)
        {
            Collections.shuffle(this.baralho); // Embaralha randomicamente o baralho
        }
    }

    public void incrementaTopo()
    {
        this.IDtopo++;
    }
}
