package jogador;

import java.util.ArrayList;

public class InteligenciaArtificial
{
    private String option;

    public String tomaDecisao(int valorDealer, int valorMao, boolean doubleIsValid)
    {
        if(verificaDouble(valorDealer, valorMao) && doubleIsValid)
        {
            System.out.print("double\n");
            option = "double";
        }

        else if(verificaHit(valorDealer, valorMao))
        {
            System.out.print("hit\n");
            option = "hit";
        }

        else if(verificaStand(valorDealer, valorMao))
        {
            System.out.print("stand\n");
            option = "stand";
        }

        return option;
    }

    private boolean verificaDouble(int valorDealer, int valorMao)
    {
        if(valorMao == 9 && (valorDealer == 3 || valorDealer == 4 || valorDealer == 5 || valorDealer == 6))
            return true;

        else if(valorMao == 10 && (valorDealer == 2 || valorDealer == 3 || valorDealer == 4 || valorDealer == 5 || valorDealer == 6 || valorDealer == 7 || valorDealer == 8 || valorDealer == 9))
            return true;

        else if(valorMao == 11 && (valorDealer == 2 || valorDealer == 3 || valorDealer == 4 || valorDealer == 5 || valorDealer == 6 || valorDealer == 7 || valorDealer == 8 || valorDealer == 9 || valorDealer == 10))
            return true;

        return false;
    }

    private boolean verificaHit(int valorDealer, int valorMao)
    {
        if(valorMao <= 11)
            return true;

        else if(valorMao == 12 && (valorDealer == 2 || valorDealer == 3))
            return true;

        else if(valorMao >= 12 && valorMao <= 16 && (valorDealer == 7 || valorDealer == 8 || valorDealer == 9 || valorDealer == 10 || valorDealer == 11))
            return true;

        return false;
    }

    private boolean verificaStand(int valorDealer, int valorMao)
    {
        if(valorMao == 12 && (valorDealer == 4 || valorDealer == 5 || valorDealer == 6))
            return true;

        else if(valorMao >= 13 && valorMao <= 16 && (valorDealer == 2 || valorDealer == 3 || valorDealer == 4 || valorDealer == 5 || valorDealer == 6))
            return true;

        else if(valorMao >= 17)
            return true;

        return false;
    }
}
