public class Endereco {
    private String estado, cidade, bairro, rua;
    private int num;


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

}