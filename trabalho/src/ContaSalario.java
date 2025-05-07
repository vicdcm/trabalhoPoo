public class ContaSalario extends Conta{
    private double limSaque, limTransacao;

    public ContaSalario(int senha, int nroConta,Agencia ag,double saldo,Cliente cliente,double limTransacao,double limSaque)
    {
        super(senha,nroConta,ag,saldo,cliente);

        this.limSaque = limSaque;
        this.limTransacao = limTransacao;

    }

    @Override
    public void deposito(float val, String canal) throws IllegalArgumentException {
        if(val > limTransacao) throw new IllegalArgumentException("Acima do limite");
        super.deposito(val, canal);
    }

    @Override
    public void saque(int pwd, float val, String canal) throws IllegalArgumentException {
        if(val > limSaque) throw new IllegalArgumentException("Acima do limite");
        super.saque(pwd, val, canal);
    }

    @Override
    public void pagar(int pwd, float val, String canal, Conta c) throws IllegalArgumentException {
        if(val > limTransacao) throw new IllegalArgumentException("Acima do limite");
        super.pagar(pwd, val, canal, c);
    }
}
