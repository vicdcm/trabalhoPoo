import java.io.Serializable;
import java.util.ArrayList;

public class Funcionario extends Pessoa {
    protected int anoIngresso;
    protected String sexo, cargo, nroCarteiraT, rg;
    protected float salario;

    public Funcionario(String nome, String estadoCivil, String dataNascimento, String cpf, Endereco end, String nroCarteiraT, String rg, int anoIngresso, String sexo, String cargo, float salario) {
        super(nome, estadoCivil, dataNascimento, cpf, end);
        this.nroCarteiraT = nroCarteiraT;
        this.rg = rg;
        this.anoIngresso = anoIngresso;
        this.sexo = sexo;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Funcionario(String nome, String estadoCivil, String dataNascimento, String cpf, Endereco end, String sexo, String nroCarteiraT, String rg, float salario) {
        super(nome, estadoCivil, dataNascimento, cpf, end);
        this.sexo = sexo;
        this.nroCarteiraT = nroCarteiraT;
        this.rg = rg;
        this.salario = salario;
    }

    public Funcionario()
    {
        super();
    }

    public float calcularSalario() {
        int anosEmpresa = 2025 - anoIngresso;

        if (anosEmpresa > 15) {
            return salario + (salario * 0.10f);
        } else {
            return salario;
        }
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

public String getNroCarteiraT()
{
    return nroCarteiraT;
}

public String getRg()
{
    return rg;
}

public int getAnoIngresso() 
{
    return anoIngresso;
}

public String getSexo() 
{
    return sexo;
}

public String getCargo() 
{
    return cargo;
}

public float getSalario() 
{
    return salario;
}

// Setters
public void setNroCarteiraT(String nroCarteiraT)
{
    this.nroCarteiraT = nroCarteiraT;
}

public void setRg(String rg)
{
    this.rg = rg;
}

public void setAnoIngresso(int anoIngresso) 
{
    this.anoIngresso = anoIngresso;
}

public void setSexo(String sexo) 
{
    this.sexo = sexo;
}

public void setCargo(String cargo) 
{
    this.cargo = cargo;
}

public void setSalario(float salario) 
{
    this.salario = salario;
}

}
