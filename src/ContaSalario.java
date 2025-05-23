import java.io.Serial;
import java.util.ArrayList;

public class ContaSalario extends Conta{
    private double limSaque, limTransacao;
    @Serial
    private static final long serialVersionUID = 8674361295091108998L;

    public ContaSalario(int senha, int nroConta,Agencia ag,double saldo,Cliente cliente,double limTransacao,double limSaque)
    {
        super(senha,nroConta,ag,saldo,cliente);
        this.limSaque = limSaque;
        this.limTransacao = limTransacao;
    }

    // construtor para mais de um cliente
    public ContaSalario(int senha, int nroConta, Agencia ag, double saldo, ArrayList<Cliente> clientes, double limTransacao, double limSaque)
    {
        super(senha,nroConta,ag,saldo,clientes);
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
