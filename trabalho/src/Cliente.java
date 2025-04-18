import java.util.ArrayList;

public class Cliente extends Pessoa
{
    private String escolaridade;
    private Agencia ag;


public static Cliente encontraCliente(ArrayList<Cliente> clientes,String cpf) //função busca um cliente especifico em uma lista de clientes
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

