import java.io.Serializable;
import java.util.ArrayList;

public class Gerente extends Funcionario {
    private String dataIngressouGerente;
    private boolean temFormacaoBasica;
    private Agencia ag;
    private static float comissao; //static pois enunciado

    public Gerente(String nome, String estadoCivil, String dataNascimento, String cpf, Endereco end, String nroCarteiraT, String rg, int anoIngresso, String sexo, String cargo, float salario, String dataIngressouGerente, boolean temFormacaoBasica, Agencia ag) {
        super(nome, estadoCivil, dataNascimento, cpf, end, nroCarteiraT, rg, anoIngresso, sexo, cargo, salario);
        this.dataIngressouGerente = dataIngressouGerente;
        this.temFormacaoBasica = temFormacaoBasica;
        this.ag = ag;
    }

    public Gerente(String nome, String estadoCivil, String dataNascimento, String cpf, Endereco end, String sexo, String nroCarteiraT, String rg, float salario, String dataIngressouGerente, boolean temFormacaoBasica) {
        super(nome, estadoCivil, dataNascimento, cpf, end, sexo, nroCarteiraT, rg, salario);
        this.dataIngressouGerente = dataIngressouGerente;
        this.temFormacaoBasica = temFormacaoBasica;
    }

    public Gerente()
    {
        super();
    }

    //metodo calcular salário do gerente
 @Override
 public float calcularSalario(){
     float salarioGerente;
     salarioGerente = super.calcularSalario();
     return salarioGerente + comissao;
 }
 
 //gets e sets

public String getDataDeNascimento() {
    return dataNascimento;
}
public void setDataDeNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
}
public boolean getTemFormacaoBasica() {
    return temFormacaoBasica;
}
public void setTemFormacaoBasica(boolean temFormacaoBasica) {
    this.temFormacaoBasica = temFormacaoBasica;
}
public Agencia getAg() {
    return ag;
}
public void setAg(Agencia ag) {
    this.ag = ag;
}

    public int getAno()
    {
        return anoIngresso;
    }

public static float getComissao() {
    return comissao;
}
    public static void setComissao(float comissao)  
    {
    Gerente.comissao = comissao;
    }

    public static Funcionario encontraFuncionario(ArrayList<Funcionario> funcionarios, String cpf) //função busca um cliente especifico em uma lista de clientes
{
    for(Funcionario buscaFuncionario : funcionarios)
    {
        if(buscaFuncionario.getcpf().equals(cpf))
        {
            return buscaFuncionario;
        }
    }

    return null;

}

}
