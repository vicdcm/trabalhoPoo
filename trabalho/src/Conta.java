import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public abstract class Conta {
    private int senha, nroConta;
    private String dataAbertura, dataUltima;
    private Agencia ag;
    private double saldo;
    private boolean estaAtiva;
    private ArrayList<Cliente> clientes; 
    private ArrayList<Transacao> transacoes;

    public Conta (int senha, int nroConta,Agencia ag,double saldo,Cliente cliente) //construtor caso a conta pertença a apenas um cliente
    {
        this.senha = senha;
        this.nroConta =nroConta;
        dataAbertura = Conta.dataAtual();
        this.saldo = saldo;
        this.ag = ag; 
        this.estaAtiva = true;
        this.clientes = new ArrayList<>();
        this.transacoes = new ArrayList<>();
        clientes.add(cliente);

    } 

    public Conta (int senha, int nroConta,Agencia ag,double saldo,Cliente cliente,Cliente cliente2) //construtor caso a conta pertença a apenas um cliente
    {
        this.senha = senha;
        this.nroConta =nroConta;
        dataAbertura = Conta.dataAtual();
        this.saldo = saldo;
        this.ag = ag; 
        this.estaAtiva = true;
        this.clientes = new ArrayList<>();
        this.transacoes = new ArrayList<>();
        clientes.add(cliente);
        clientes.add(cliente2);

    }

    // Getters
    public int getSenha() {
        return senha;
    }

    public int getNroConta() {
        return nroConta;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public String getDataUltima() {
        return dataUltima;
    }

    public Agencia getAg() {
        return ag;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean getEstaAtiva() {  
        return estaAtiva;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Transacao> getTransacoes() {
        return transacoes;
    }

    // Setters
    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void setNroConta(int nroConta) {
        this.nroConta = nroConta;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void setDataUltima(String dataUltima) {
        this.dataUltima = dataUltima;
    }

    public void setAg(Agencia ag) {
        this.ag = ag;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setEstaAtiva(boolean estaAtiva) {
        this.estaAtiva = estaAtiva;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setTransacoes(ArrayList<Transacao> transacoes) {
        this.transacoes = transacoes;
    }






protected static String dataAtual()
{
    LocalDate today = LocalDate.now();

String isoDate = today.format(DateTimeFormatter.ISO_LOCAL_DATE); //converter a data para uma String
 return isoDate; 
}





}