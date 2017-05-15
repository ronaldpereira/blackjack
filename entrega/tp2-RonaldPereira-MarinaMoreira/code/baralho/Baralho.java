package baralho;

public class Baralho // Classe que representa o baralho inteiro, contendo as atribuicoes de cada carta dele
{
    private String nome; // Guarda o nome da carta
    private String naipe; // Guarda o nome da carta
    private int valor; // Guarda o valor relativo a carta
    private boolean isOnTheTable = false; // Flag para marcar se a carta esta na mesa ou nao

    void criaCarta(String nome, String naipe) // Metodo que realiza a criacao de uma nova carta no baralho somente para o pacote baralho
    {
        this.nome = nome;
        this.naipe = naipe;
        atribuiValor(nome);
    }

    private void atribuiValor(String nome) // Metodo que realiza a atribuicao do valor a carta
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

    public void cartaPuxada() // Metodo que seta a flag isOnTheTable para true se a carta foi puxada no jogo
    {
        this.isOnTheTable = true;
    }

    public int retornaValor() // Metodo que retorna o valor da carta
    {
        return valor;
    }

    public String retornaNomeeNaipe() // Metodo que retorna o nome e o naipe da carta concatenados
    {
        return nome+" "+naipe;
    }

    public String retornaNome() // Metodo que retorna o nome da carta
    {
        return nome;
    }

    public boolean retornaUso() // Metodo que retorna se a carta ja foi puxada
    {
        return this.isOnTheTable;
    }
}
