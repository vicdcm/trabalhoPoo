import java.util.ArrayList;
import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable
{
    private String escolaridade;
    private Agencia ag;

    public Cliente() {
        super();
    }

    public Cliente(String nome, String cpf) {
        super(nome, null, null, cpf, null);
    }

    public Cliente(String nome, String estadoCivil, String dataNascimento, String cpf, Endereco end, String escolaridade, Agencia ag) {
        super(nome, estadoCivil, dataNascimento, cpf, end);
        this.escolaridade = escolaridade;
        this.ag = ag;
    }

    public static Cliente encontraCliente(ArrayList<Cliente> clientes, String cpf) //função busca um cliente especifico em uma lista de clientes
{
    for(Cliente buscaCliente : clientes)
    {
        if(buscaCliente.getcpf().equals(cpf))
        {
            return buscaCliente;
        }
    }

    return null;

}

public String getEscolaridade()
{
    return this.escolaridade;
}


 public Agencia getAgencia()
 {
    return this.ag;
 }

 public void setEscolaridade(String e)
{
    this.escolaridade = e;
}


 public void setAgencia(Agencia a)
 {
    this.ag = a;
 }
}

