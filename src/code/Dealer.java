import java.util.ArrayList;

public class Dealer
{
    private ArrayList<Integer> IDcartas = new ArrayList<Integer>();
    private int valorMao = 0;

    public void pegaCarta(int id, int valor)
    {
        this.IDcartas.add(id);

        this.valorMao += valor;
    }

    public void descartaMao()
    {
        this.IDcartas.clear();
        this.valorMao = 0;
    }

    public int retornaValorMao()
    {
        return this.valorMao;
    }

    public ArrayList<Integer> retornaIDcartas()
    {
        return this.IDcartas;
    }
}
