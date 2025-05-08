import java.io.Serial;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;


public abstract class Conta implements Serializable{
    private int senha, nroConta;
    private String dataAbertura, dataUltima;
    private Agencia ag;
    private double saldo;
    private boolean estaAtiva;
    private ArrayList<Cliente> clientes; 
    private ArrayList<Transacao> transacoes;
    @Serial
    private static final long serialVersionUID = -1311738598776416552L;

    public Conta (int senha, int nroConta,Agencia ag,double saldo,Cliente cliente) //construtor caso a conta pertença a apenas um cliente
    {
        this.senha = senha;
        this.nroConta =nroConta;
        dataAbertura = Conta.dataAtual();
        this.saldo = saldo;
        this.ag = ag; 
        this.estaAtiva = true;
        this.clientes = new ArrayList<Cliente>();
        this.transacoes = new ArrayList<Transacao>();
        clientes.add(cliente);
        this.dataUltima = Conta.dataAtual();
    } 

    public Conta (int senha, int nroConta, Agencia ag, double saldo, ArrayList<Cliente> clientes) //construtor caso a conta pertença a n clientes
    {
        this.senha = senha;
        this.nroConta =nroConta;
        dataAbertura = Conta.dataAtual();
        this.saldo = saldo;
        this.ag = ag; 
        this.estaAtiva = true;
        this.transacoes = new ArrayList<>();
        this.clientes = clientes;
        this.dataUltima = Conta.dataAtual();
    }
    
    //add metodos sacar, depositar e getSaldo
    public boolean sacar(double valor) {
    if (valor <= saldo) {
        saldo -= valor;
        return true;
    } else {
        System.out.println("Saldo insuficiente.");
        return false;
    }
}

    public void depositar(double valor) {
    if (valor > 0) {
        saldo += valor;
    } else {
        System.out.println("Valor de depósito inválido.");
    }
}

    public double getSaldo() {
    return saldo;
}


    public void deposito(float val, String canal) throws IllegalArgumentException{
        Transacao nova = new Transacao(this, "deposito", val, canal);
        dataUltima = Conta.dataAtual();
        this.transacoes.add(nova);
        nova.setOcorreu(true);
        if(val <= 0) throw new IllegalArgumentException("Valor invalido para deposito");
        saldo += val;
    }

    public void saque(int pwd, float val, String canal) throws IllegalArgumentException {
        Transacao nova = new Transacao(this, "saque", val, canal);
        dataUltima = Conta.dataAtual();
        this.transacoes.add(nova);
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        nova.setOcorreu(true);
        if(val <= 0) throw new IllegalArgumentException("Valor invalido para saque");
        if(saldo - val < 0) throw new IllegalArgumentException("Saldo insuficiente");
        this.setSaldo(saldo-val, pwd);
    }

    public void consulta(int pwd, String canal) {
        Transacao nova = new Transacao(this, "consulta", 0, canal);
        dataUltima = Conta.dataAtual();
        this.transacoes.add(nova);
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        nova.setOcorreu(true);
        System.out.println("Seu saldo é: " + this.getSaldo(pwd));
    }

    public void pagar(int pwd, float val, String canal, Conta c) throws IllegalArgumentException{
        Transacao nova = new Transacao(this, "pagar", val, canal);
        dataUltima = Conta.dataAtual();
        this.transacoes.add(nova);
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        nova.setOcorreu(true);
        if(val <= 0) throw new IllegalArgumentException("Valor invalido para saque");
        if(saldo - val < 0) throw new IllegalArgumentException("Saldo insuficiente");
        this.setSaldo(saldo-val, pwd);
    }

    // Getters
    public int getNroConta() throws SenhaInvalidaException{
        return nroConta;
    }

    public String getDataAbertura(int pwd) throws SenhaInvalidaException{
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        return dataAbertura;
    }

    public String getDataUltima(int pwd) throws SenhaInvalidaException{
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        return dataUltima;
    }

    public Agencia getAg(int pwd) throws SenhaInvalidaException {
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        return ag;
    }

    public double getSaldo(int pwd) throws SenhaInvalidaException{
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        return saldo;
    }

    public boolean getEstaAtiva(int pwd)  throws SenhaInvalidaException{
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        return estaAtiva;
    }

    public ArrayList<Cliente> getClientes(int pwd) throws SenhaInvalidaException {
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        return clientes;
    }

    public ArrayList<Transacao> getTransacoes(int pwd) throws SenhaInvalidaException {
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        return transacoes;
    }

    // Setters

    public void setNroConta(int nroConta, int pwd) throws SenhaInvalidaException{
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        this.nroConta = nroConta;
    }

    public void setDataAbertura(String dataAbertura, int pwd) throws SenhaInvalidaException{
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        this.dataAbertura = dataAbertura;
    }

    public void setDataUltima(String dataUltima, int pwd) throws SenhaInvalidaException{
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        this.dataUltima = dataUltima;
    }

    public void setAg(Agencia ag, int pwd) throws SenhaInvalidaException {
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        this.ag = ag;
    }

    public void setSaldo(double saldo, int pwd)  throws IllegalArgumentException{
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        if(saldo < 0) throw new IllegalArgumentException("Saldo negativo");
        this.saldo = saldo;
    }

    public void setEstaAtiva(boolean estaAtiva, int pwd) throws SenhaInvalidaException{
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        this.estaAtiva = estaAtiva;
    }

    public void setClientes(ArrayList<Cliente> clientes, int pwd) throws SenhaInvalidaException{
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        this.clientes = clientes;
    }

    public void setTransacoes(ArrayList<Transacao> transacoes, int pwd) throws SenhaInvalidaException{
        if(pwd != this.senha) throw new SenhaInvalidaException("Senha invalida");
        this.transacoes = transacoes;
    }


    public static String dataAtual()
    {
        LocalDate today = LocalDate.now();

        String isoDate = today.format(DateTimeFormatter.ISO_LOCAL_DATE); //converter a data para uma String
        return isoDate;
    }





}
