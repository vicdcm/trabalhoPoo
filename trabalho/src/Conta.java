import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public abstract class Conta {
    private int senha, nroConta;
    private String dataAbertura, dataUltima;
    private Agencia ag;
    private float saldo;
    private boolean estaAtiva;
    private ArrayList<Cliente> clientes; 
    private ArrayList<Transacao> transacoes;

    /*public Conta (int senha, int nroConta,Agencia ag,float saldo,boolean estaAtiva,Cliente cliente) //construtor caso a conta pertença a apenas um cliente
    {

    } 

    */

//gets e sets
    public int getSenha() {
        return senha;
    }
    public void setSenha(int senha) {
        this.senha = senha;
    }
    public int getNroConta() {
        return nroConta;
    }
    public void setNroConta(int nroConta) {
        this.nroConta = nroConta;
    }
    public String getDataAbertura() {
        return dataAbertura;
    }
    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    public String getDataUltima() {
        return dataUltima;
    }
    public void setDataUltima(String dataUltima) {
        this.dataUltima = dataUltima;
    }
    public Agencia getAg() {
        return ag;
    }
    public void setAg(Agencia ag) {
        this.ag = ag;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public boolean isEstaAtiva() {
        return estaAtiva;
    }
    public void setEstaAtiva(boolean estaAtiva) {
        this.estaAtiva = estaAtiva;
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public ArrayList<Transacao> getTransacoes() {
        return transacoes;
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