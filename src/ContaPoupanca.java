import java.util.ArrayList;

public class ContaPoupanca extends Conta{
    private double RendimentoMesAtual;

    public ContaPoupanca(int senha, int nroConta,Agencia ag,double saldo,Cliente cliente,double RendimentoMesAtual)
    {
        super(senha,nroConta,ag,saldo,cliente);
        this.RendimentoMesAtual = RendimentoMesAtual;
    }

//// construtor para mais de um cliente
//    public ContaPoupanca(int senha, int nroConta, Agencia ag, double saldo, ArrayList<Cliente> clientes, double RendimentoMesAtual)
//    {
//        super(senha,nroConta,ag,saldo,clientes);
//        this.RendimentoMesAtual = RendimentoMesAtual;
//    }
}
