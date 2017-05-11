public class InteligenciaArtificial
{
    public void tomaDecisao()
    {
        if(verificaHit())
        {
            System.out.print("hit\n");
        }

        else if(verificaStand())
        {
            System.out.print("stand\n");
        }

        else if(verificaDouble())
        {
            System.out.print("double\n");
        }

        else if(verificaSplit())
        {
            System.out.print("split\n");
        }
    }

    private boolean verificaHit()
    {
        boolean dahit = false;

        return dahit;
    }

    private boolean verificaStand()
    {
        boolean dastand = false;

        return dastand;
    }

    private boolean verificaDouble()
    {
        boolean dadouble = false;

        return dadouble;
    }

    private boolean verificaSplit()
    {
        boolean dasplit = false;

        return dasplit;
    }
}
