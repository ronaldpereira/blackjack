public class Baralho
{
    private String nome;
    private String naipe;
    private int valor;
    private boolean isOnTheTable = false;

    public void criaCarta(String nome, String naipe)
    {
        this.nome = nome;
        this.naipe = naipe;
        atribuiValor(nome);
    }

    private void atribuiValor(String nome)
    {
        if("A".equals(nome))
        {
            this.valor = 11;
        }

        else if("J".equals(nome) || "Q".equals(nome) || "K".equals(nome))
        {
            this.valor = 10;
        }

        else
        {
            this.valor = Integer.parseInt(nome);
        }
    }

    public void cartaPuxada()
    {
        this.isOnTheTable = true;
    }

    public int retornaValor()
    {
        return valor;
    }

    public String retornaNomeeNaipe()
    {
        return nome+" of "+naipe;
    }

    public boolean retornaUso()
    {
        return this.isOnTheTable;
    }
}
