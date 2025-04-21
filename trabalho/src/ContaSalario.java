public class ContaSalario extends Conta{
    private double limSaque, limTransacao;

    public ContaSalario(int senha, int nroConta,Agencia ag,float saldo,Cliente cliente,double limTransacao,double limSaque)
    {
        super(senha,nroConta,ag,saldo,cliente);

        this.limSaque = limSaque;
        this.limTransacao = limTransacao;

    }
}
