import java.util.ArrayList;

public class InteligenciaArtificial
{
    private static String option;

    public static String tomaDecisao(int valorDealer, int valorMao, boolean doubleIsValid)
    {
        if(verificaHit(valorDealer))
        {
            System.out.print("hit\n");
            option = "hit";
        }

        else if(verificaStand(valorDealer))
        {
            System.out.print("stand\n");
            option = "stand";
        }

        else if(verificaSplit(valorDealer))
        {
            System.out.print("split\n");
            option = "split";
        }

        else if(verificaDouble(valorDealer) && doubleIsValid)
        {
            System.out.print("double\n");
            option = "double";
        }

        return option;
    }

    private static boolean verificaHit(int valorDealer)
    {
        boolean dahit = false;

        return dahit;
    }

    private static boolean verificaStand(int valorDealer)
    {
        boolean dastand = false;

        return dastand;
    }

    private static boolean verificaDouble(int valorDealer)
    {
        boolean dadouble = false;

        return dadouble;
    }

    private static boolean verificaSplit(int valorDealer)
    {
        boolean dasplit = false;

        return dasplit;
    }
}
