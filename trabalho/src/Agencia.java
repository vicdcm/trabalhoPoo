public class Agencia {
    private int num;
    private String nome;
    private Endereco end;
    private Gerente ger;

    //gets
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEnd() {
        return end;
    }

    //sets

    public void setEnd(Endereco end) {
        this.end = end;
    }

    public Gerente getGer() {
        return ger;
    }

    public void setGer(Gerente ger) {
        this.ger = ger;
    }
}
