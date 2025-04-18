public class Funcionario extends Pessoa{
    protected int nroCarteiraT, rg, anoIngresso;
    protected String sexo, cargo;
    protected float salario;

    public float calcularSalario() {
        int anosEmpresa = 2025 - anoIngresso;

        if (anosEmpresa > 15) {
            return salario + (salario * 0.10f);
        } else {
            return salario;
        }
    }

}
