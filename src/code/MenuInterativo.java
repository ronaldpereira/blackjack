import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuInterativo
{
    private static int numJogadores;
    static BufferedReader reader;

    public static void apresentacao()
    {
        System.out.println("Bem-vindo ao JackBlack 2017/2");
        System.out.println("Autores: Marina Monteiro Moreira e Ronald Davi Rodrigues Pereira");
    }

    public static void interage()
    {
        pegaNumJogadores();

    }

    public static void pegaNumJogadores() throws Exception
    {
        System.out.print("Insira o numero de jogadores: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        numJogadores = Integer.parseInt(reader.readLine());
    }

}
