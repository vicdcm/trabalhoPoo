import java.util.ArrayList;

public class ContaCorrente extends Conta{
    private double limChequeEspecial, taxaAdministrativa;
    private static final long serialVersionUID = 6072982411827984035L;

    public ContaCorrente (int senha, int nroConta,Agencia ag,double saldo,Cliente cliente, double limChequeEspecial,double taxaAdministrativa)
    {
        super(senha,nroConta,ag,saldo,cliente);
        this.limChequeEspecial = limChequeEspecial;
        this.taxaAdministrativa=taxaAdministrativa;
    }

    // construtor para mais de um cliente
    public ContaCorrente(int senha, int nroConta, Agencia ag, double saldo, ArrayList<Cliente> clientes, double limChequeEspecial, double taxaAdministrativa) {
        super(senha, nroConta, ag, saldo, clientes);
        this.limChequeEspecial = limChequeEspecial;
        this.taxaAdministrativa = taxaAdministrativa;
    }

}
