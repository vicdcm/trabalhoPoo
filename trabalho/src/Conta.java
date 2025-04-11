import java.util.ArrayList;

public abstract class Conta {
    private int senha, nroConta;
    private String dataAbertura, dataUltima;
    private Agencia ag;
    private float saldo;
    private boolean estaAtiva;
    private ArrayList<Transacao> transacoes;
}
