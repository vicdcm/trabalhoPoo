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




protected static String dataAtual()
{
    LocalDate today = LocalDate.now();

String isoDate = today.format(DateTimeFormatter.ISO_LOCAL_DATE); //converter a data para uma String
 return isoDate; 
}

}