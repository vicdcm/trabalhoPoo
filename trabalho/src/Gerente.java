public class Gerente extends Funcionario{
    private String dataIngressouGerente;
    private boolean temFormacaoBasica;
    private Agencia ag;
    private float comissao;

 //metodo calcular salário do gerente   
 @Override
 public float calcularSalario(){
     float salarioGerente;
     salarioGerente = super.calcularSalario();
     return salarioGerente + comissao;
 }
 
 //gets e sets
 public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
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
public float getComissao() {
    return comissao;
}
public void setComissao(float comissao) {
    this.comissao = comissao;
}

}
