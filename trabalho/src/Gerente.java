import java.io.Serializable;

public class Gerente extends Funcionario {
    private String dataIngressouGerente;
    private boolean temFormacaoBasica;
    private Agencia ag;
    private static float comissao; //static pois enunciado

    public Gerente(String nome, String estadoCivil, String dataNascimento, String cpf, Endereco end, int nroCarteiraT, int rg, int anoIngresso, String sexo, String cargo, float salario, String dataIngressouGerente, boolean temFormacaoBasica, Agencia ag) {
        super(nome, estadoCivil, dataNascimento, cpf, end, nroCarteiraT, rg, anoIngresso, sexo, cargo, salario);
        this.dataIngressouGerente = dataIngressouGerente;
        this.temFormacaoBasica = temFormacaoBasica;
        this.ag = ag;
    }

    //metodo calcular salário do gerente
 @Override
 public float calcularSalario(){
     float salarioGerente;
     int anosEmpresa = 2025 - anoIngresso;
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
public static float getComissao() {
    return comissao;
}
public static void setComissao(float comissao) {
    comissao = comissao;
}
}
