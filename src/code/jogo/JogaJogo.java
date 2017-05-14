package jogo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import jogador.InteligenciaArtificial;

public class JogaJogo
{
    private static jogador.Jogador[] jogador; // Vetor de jogadores
    private static ArrayList<baralho.Baralho> baralho; // Array de objetos do tipo Baralho para guardar as cartas do baralho
    private static jogador.Dealer dealer = new jogador.Dealer(); // Dealer do jogo
    private static jogador.InteligenciaArtificial inteligenciaartificial = new jogador.InteligenciaArtificial(); // Inteligencia Artificial
    private static int numJogadores; // Guarda o numero de jogadores
    private static BufferedReader reader; // Leitor da entrada
    private static String option; // Guarda a opcao do jogador

    public void atribuiBaralho()
    {
        baralho.CriaBaralho criadorBaralho = new baralho.CriaBaralho();
        baralho = criadorBaralho.criaeEmbaralhaBaralho();
    }

    public void jogada() throws Exception
    {
        menu.MenuInterativo menu = new menu.MenuInterativo();
        jogador = menu.executaMenu();
        numJogadores = menu.retornaNumJogadores();
        atribuiBaralho();

        int numRodadas = 0;
        String continuar = "sim";
        while(true)
        {
            if(verificaSaldoJogadores())
            {
                numRodadas++;
                if(numRodadas == 10)
                {
                    System.out.print("\nO baralho esta sendo recomposto e embaralhado...\n");
                    atribuiBaralho();
                    numRodadas = 0;
                }

                for(int i = 1; i <= numJogadores; i++)
                    jogador[i].fazAposta();

                dealerComecaRodada();

                for(int i = 1; i <= numJogadores; i++)
                {
                    if(jogador[i].retornaAposta() > 0)
                        jogador[i].fazJogada(baralho, i);
                }

                if(verificaMaoJogadores())
                {
                    System.out.print("\nVez do Dealer\n");
                    dealerTerminaRodada();
                }

                distribuiPremios();

                System.out.print("\nDeseja jogar mais uma rodada? <sim, nao>: ");
                reader = new BufferedReader(new InputStreamReader(System.in));
                continuar = reader.readLine();

                if("nao".equals(continuar))
                {
                    imprimeSaldos();
                    break;
                }

                else
                {
                    preparaNovaRodada();
                }
            }

            else
            {
                System.out.println("O jogo terminou por insuficiencia de saldo dos jogadores");
                imprimeSaldos();
                break;
            }
        }
    }

    public void imprimeSaldos()
    {
        System.out.print("\n\nSaldo final dos jogadores:\n");

        for(int i = 1; i <= numJogadores; i++)
            System.out.println(jogador[i].retornaNomeJogador()+" : R$ "+jogador[i].retornaSaldo());

        System.out.print("\n\nObrigado por jogar JackBlack 2017/1!\n");
    }

    public boolean verificaMaoJogadores()
    {
        for(int i = 1; i <= numJogadores; i++)
        {
            if(jogador[i].retornaValorMao() <= 21)
                return true;
        }

        return false;
    }

    public boolean verificaSaldoJogadores()
    {
        for(int i = 1; i <= numJogadores; i++)
        {
            if(jogador[i].retornaSaldo() >= 10)
                return true;
        }

        return false;
    }

    public void distribuiPremios()
    {
        int maoDealer = dealer.retornaValorMao();
        int auxValorMao;

        if(maoDealer > 21) // Se o dealer estourou a mao, todos os jogadores ganham
            maoDealer = 0;

        System.out.print("\n\nResultados da rodada:\n");

        for(int i = 1; i <= numJogadores; i++)
        {
            if(jogador[i].retornaAposta() > 0)
            {
                auxValorMao = jogador[i].retornaValorMao();

                if(jogador[i].retornaValorMao() > 21)
                    jogador[i].estourouMao();

                if(jogador[i].retornaValorMao() > maoDealer)
                {
                    System.out.print("\n"+jogador[i].retornaNomeJogador()+" ganhou R$ "+jogador[i].retornaAposta()*2);
                    jogador[i].aumentaSaldo(jogador[i].retornaAposta()*2);
                }

                else if(jogador[i].retornaValorMao() == maoDealer)
                {
                    System.out.print("\nO Dealer devolveu R$ "+jogador[i].retornaAposta()+" da aposta para "+jogador[i].retornaNomeJogador());
                    jogador[i].aumentaSaldo(jogador[i].retornaAposta());
                }

                else
                    System.out.print("\n"+jogador[i].retornaNomeJogador()+" perdeu");

                System.out.println(" com uma mao de valor "+auxValorMao);
            }
        }
    }

    public void dealerComecaRodada()
    {
        dealer.pegaCarta(0, baralho.get(0).retornaValor());
        baralho.get(0).cartaPuxada();
        System.out.print("\nInicio da rodada:\n\nO Dealer vira na mesa a carta "+baralho.get(0).retornaNomeeNaipe()+"\n\nO valor da mao do Dealer e "+baralho.get(0).retornaValor()+"\n");
    }

    public void dealerTerminaRodada()
    {
        while(dealer.retornaValorMao() < 17)
        {
            for(int i = 1; ; i++)
            {
                if(!(baralho.get(i).retornaUso())) // Carta nao esta na mesa
                {
                    baralho.get(i).cartaPuxada();
                    dealer.pegaCarta(i, baralho.get(i).retornaValor());
                    System.out.println("Foi puxada a carta: "+baralho.get(i).retornaNomeeNaipe());
                    break;
                }
            }
            System.out.println(dealer.retornaIDcartas());
            System.out.println("O valor da mao do dealer e "+dealer.retornaValorMao());
        }
    }

    public void preparaNovaRodada()
    {
        for(int i = 1; i <= numJogadores; i++)
            jogador[i].descartaMao();

        dealer.descartaMao();

        while(baralho.get(0).retornaUso())
            baralho.remove(0);
    }

    public static String decisao(ArrayList<baralho.Baralho> baralho, int id) throws Exception
    {
        if(jogador[id].retornaNumCartas() == 0)
        {
            distribuiCartas(baralho, id);
            System.out.println(jogador[id].retornaIDcartas());
            System.out.print("O valor da mao e: "+jogador[id].retornaValorMao()+"\n\n");
        }

        System.out.print("\n"+jogador[id].retornaNomeJogador()+", qual a sua jogada? <hit/double/stand>: ");

        if(jogador[id].retornaIsIA())
            option = inteligenciaartificial.tomaDecisao(dealer.retornaValorMao(), jogador[id].retornaValorMao(), (jogador[id].verificaDouble()));

        else
        {
            reader = new BufferedReader(new InputStreamReader(System.in));
            option = reader.readLine();
        }

        if("hit".equals(option))
        {
            distribuiCartas(baralho, id);
            System.out.println(jogador[id].retornaIDcartas());
            System.out.print("O valor da mao e: "+jogador[id].retornaValorMao()+"\n\n");
        }

        else if("stand".equals(option))
        {
            System.out.print("O valor da mao de "+jogador[id].retornaNomeJogador()+" e "+jogador[id].retornaValorMao()+"\n\n");
        }

        else if("double".equals(option))
        {
            if(jogador[id].verificaDouble())
            {
                jogador[id].daDouble();
                distribuiCartas(baralho, id);
            }

            else
            {
                System.out.println("\n"+jogador[id].retornaNomeJogador()+", seu saldo e insuficiente para dar double");
                option = "";
            }

            System.out.println(jogador[id].retornaIDcartas());
            System.out.print("O valor da mao e: "+jogador[id].retornaValorMao()+"\n\n");
        }

        if(jogador[id].retornaValorMao() == 21)
        {
            System.out.print("BlackJack de "+jogador[id].retornaNomeJogador()+"!"+"\n\n");
            System.out.print("O valor final da mao de "+jogador[id].retornaNomeJogador()+" e "+jogador[id].retornaValorMao()+"\n\n");
            option = "stand";
        }

        else if(jogador[id].retornaValorMao() > 21)
        {
            System.out.print("Perdeu! O valor final da mao de "+jogador[id].retornaNomeJogador()+" e "+jogador[id].retornaValorMao()+"\n\n");
            option = "stand";
        }

        return option;
    }

    public static void distribuiCartas(ArrayList<baralho.Baralho> baralho, int id)
    {
        for(int i = 1; ; i++)
        {
            if(!(baralho.get(i).retornaUso())) // Carta nao esta na mesa
            {
                baralho.get(i).cartaPuxada();
                jogador[id].pegaCarta(i, baralho.get(i).retornaValor());
                System.out.println("Foi puxada a carta: "+baralho.get(i).retornaNomeeNaipe());
                return;
            }
        }
    }
}
