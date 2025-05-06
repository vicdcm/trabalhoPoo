public class ContaPoupanca extends Conta{
    private double RendimentoMesAtual;

    public ContaPoupanca(int senha, int nroConta,Agencia ag,double saldo,Cliente cliente,double RendimentoMesAtual)
    {
        super(senha,nroConta,ag,saldo,cliente);
        this.RendimentoMesAtual = RendimentoMesAtual;
    }
}
