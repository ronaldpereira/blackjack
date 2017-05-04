import java.util.ArrayList;

public class Dealer
{
    private ArrayList<Integer> IDcartas;
    private int soma = 0;

    public void puxaCarta(int ID, int valor)
    {
        this.IDcartas.add(ID);
        this.soma += valor;
    }

    public void descartaMao()
    {
        this.IDcartas.clear();
        this.soma = 0;
    }

    public int exibeSoma()
    {
        return this.soma;
    }

    public ArrayList<Integer> exibeMao()
    {
        return this.IDcartas;
    }
}
