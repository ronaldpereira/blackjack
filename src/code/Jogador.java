import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jogador
{
    private ArrayList<Integer> IDcartas = new ArrayList<Integer>();
    private String nomeJogador;
    private boolean isIA = false; // Flag para verificar se o jogador e uma inteligencia artificial
    private double saldo;
    private double aposta = 0;
    private int numDeA = 0;
    private int valorMao = 0;
    private int numCartas = 0;
    private BufferedReader reader;

    public void fazJogada(ArrayList<Baralho> baralho, int id) throws Exception
    {
        String option = "";

        InteligenciaArtificial IA = new InteligenciaArtificial();
        if(isIA)
        {
            System.out.print(this.nomeJogador+", qual a sua jogada? <hit/double/split/stand>: ");
            IA.tomaDecisao();
        }

        else
        {
            System.out.print("\nVez de "+this.nomeJogador+"\n");

            while(!("stand".equals(option)) && !("double".equals(option)))
                option = JogaJogo.decisao(baralho, id);
        }
    }

    public void daDouble()
    {
        this.saldo -= this.aposta;
        this.aposta *= 2;
    }

    public void fazAposta() throws Exception
    {
        if(this.saldo >= 10)
        {
            while(this.aposta < 10 || this.aposta > this.saldo)
            {
                System.out.print("\n"+this.nomeJogador+", seu saldo atual e R$ "+this.saldo);
                System.out.print("\n"+this.nomeJogador+", qual a sua aposta? (min. R$ 10.00): R$ ");
                reader = new BufferedReader(new InputStreamReader(System.in));
                this.aposta = Double.parseDouble(reader.readLine());
            }
            diminuiSaldo(aposta);
        }

        else
            System.out.print("\n"+this.nomeJogador+", seu saldo e insuficiente.\nSaldo atual e R$ "+this.saldo+"\n\n");
    }

    public void aumentaSaldo(double valor)
    {
        this.saldo += valor;
    }

    public void diminuiSaldo(double valor)
    {
        this.saldo -= valor;
    }

    public void estourouMao()
    {
        this.valorMao = -1;
    }

    public void pegaCarta(int id, int valor)
    {
        this.IDcartas.add(id);
        numCartas++;
        if(valor == 11)
        {
            this.valorMao += valor;
            this.numDeA++;
        }
        else
            this.valorMao += valor;

        if(this.valorMao > 21 && numDeA > 0)
        {
            this.valorMao -= numDeA * 10;
            numDeA = 0;
        }
    }

    public void descartaMao()
    {
        this.IDcartas.clear();
        this.valorMao = 0;
        this.numCartas = 0;
        this.numDeA = 0;
        this.aposta = 0;
    }

    public void pegaNomeJogador(int id) throws Exception
    {
        System.out.print("Insira o nome do jogador "+id+" : ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String nome = reader.readLine();

        if("IA".equals(nome))
        {
            this.nomeJogador = "Inteligencia Artificial "+id;
            this.isIA = true;
        }

        else
            this.nomeJogador = nome;
    }

    public String retornaNomeJogador()
    {
        return this.nomeJogador;
    }

    public double retornaSaldo()
    {
        return this.saldo;
    }

    public double retornaAposta()
    {
        return this.aposta;
    }

    public int retornaValorMao()
    {
        return this.valorMao;
    }

    public int retornaNumCartas()
    {
        return this.numCartas;
    }

    public ArrayList<Integer> retornaIDcartas()
    {
        return this.IDcartas;
    }
}
