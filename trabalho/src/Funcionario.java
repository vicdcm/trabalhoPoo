import java.io.Serializable;

public class Funcionario extends Pessoa {
    protected int nroCarteiraT, rg, anoIngresso;
    protected String sexo, cargo;
    protected float salario;

    public Funcionario(String nome, String estadoCivil, String dataNascimento, String cpf, Endereco end, int nroCarteiraT, int rg, int anoIngresso, String sexo, String cargo, float salario) {
        super(nome, estadoCivil, dataNascimento, cpf, end);
        this.nroCarteiraT = nroCarteiraT;
        this.rg = rg;
        this.anoIngresso = anoIngresso;
        this.sexo = sexo;
        this.cargo = cargo;
        this.salario = salario;
    }

    public float calcularSalario() {
        int anosEmpresa = 2025 - anoIngresso;

        if (anosEmpresa > 15) {
            return salario + (salario * 0.10f);
        } else {
            return salario;
        }
    }

}
