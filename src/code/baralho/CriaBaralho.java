package baralho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CriaBaralho // Classe que realiza as operacoes necessarias para criar um baralho completo
{
    private ArrayList<Baralho> baralho; // Array de objetos do tipo Baralho para guardar as cartas do baralho

    public ArrayList<Baralho> criaeEmbaralhaBaralho() // Metodo que realiza a criacao de um objeto do tipo Baralho (do pacote baralho) e ja realiza o embaralhamento desse objeto
    {
        String nomedacarta;
        String naipedacarta;

        this.baralho = new ArrayList<Baralho>();

        for(int deck = 1; deck <= 6; deck++) // Realiza a criacao de 6 baralhos
        {
            for(int carta = 1; carta <= 13; carta++) // Com 13 tipos de cartas (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q e K)
            {
                for(int naipe = 1; naipe <= 4; naipe++) // Com 4 naipes para cada carta
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
                        nomedacarta = "As";

                    else if(carta == 11)
                        nomedacarta = "Valete";

                    else if(carta == 12)
                        nomedacarta = "Rainha";

                    else if(carta == 13)
                        nomedacarta = "Rei";

                    else
                        nomedacarta = Integer.toString(carta);

                    Baralho card = new Baralho();
                    card.criaCarta(nomedacarta, naipedacarta); // Metodo que realiza a criacao de um objeto do tipo Baralho para a carta atual
                    baralho.add(card); // Adiciona a carta criada ao baralho
                }
            }
        }

        embaralhaBaralho();

        return this.baralho;
    }

    private void embaralhaBaralho() // Metodo que realiza o embaralhamento das cartas do baralho
    {
        Random rng = new Random();
        int aux = rng.nextInt(10000); // Gera um inteiro randomico entre 0 e 10000

        for (int i = 0; i < aux; i++)
        {
            Collections.shuffle(this.baralho); // Embaralha randomicamente o baralho
        }
    }
}
