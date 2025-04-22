import java.io.Serializable;
import java.util.Scanner;

public class Endereco implements Serializable{
    private String estado, cidade, bairro, rua;
    private int num;

    public Endereco(String estado, String cidade, String bairro, String rua, int num) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.num = num;
    }


    //gets

public String getEstado() {
    return this.estado;
}

public String getCidade() {
    return this.cidade;
}

public String getBairro() {
    return this.bairro;
}

public String getRua() {
    return this.rua;
}

public int getNum() {
    return this.num;
}

// sets
public void setEstado(String estado) {
    this.estado = estado;
}

public void setCidade(String cidade) {
    this.cidade = cidade;
}

public void setBairro(String bairro) {
    this.bairro = bairro;
}

public void setRua(String rua) {
    this.rua = rua;
}

public void setNum(int n)
{
    this.num = n;
}

//função para leitura de um endereço
public Endereco criaEnd(Scanner scan)
{
    String rua,bairro,cidade,estado;
    int num;
    num = Dados.promptInt(scan, "digite o numero da casa:");
    rua = Dados.promptStr(scan,"digite o nome da rua:");
    bairro = Dados.promptStr(scan,"digite o nome do bairro:");
    cidade = Dados.promptStr(scan,"digite o nome da cidade:");
    estado = Dados.promptStr(scan,"digite o nome do estado:");


    return new Endereco(estado,cidade,bairro,rua,num);
}

}