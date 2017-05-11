public class Baralho
{
    private String nome; // Guarda o nome da carta
    private String naipe; // Guarda o nome da carta
    private int valor; // Guarda o valor relativo a carta
    private boolean isOnTheTable = false; // Flag para marcar se a carta esta na mesa ou nao

    public void criaCarta(String nome, String naipe)
    {
        this.nome = nome;
        this.naipe = naipe;
        atribuiValor(nome);
    }

    private void atribuiValor(String nome)
    {
        if("As".equals(nome))
        {
            this.valor = 11;
        }

        else if("Valete".equals(nome) || "Rainha".equals(nome) || "Rei".equals(nome))
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
        return nome+" de "+naipe;
    }

    public boolean retornaUso()
    {
        return this.isOnTheTable;
    }
}
