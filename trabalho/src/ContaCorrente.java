public class ContaCorrente extends Conta{
    private double limChequeEspecial, taxaAdministrativa;

    public ContaCorrente (int senha, int nroConta,Agencia ag,double saldo,Cliente cliente, double limChequeEspecial,double taxaAdministrativa)
    {
        super(senha,nroConta,ag,saldo,cliente);
        this.limChequeEspecial = limChequeEspecial;
        this.taxaAdministrativa=taxaAdministrativa;
    }
}
