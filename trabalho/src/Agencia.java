import java.io.Serializable;
public class Agencia implements Serializable, Comuns{
    private int num;
    private String nome;
    private Endereco end;
    private Gerente ger;

    public Agencia(int num, String nome, Endereco end, Gerente ger) {
        this.num = num;
        this.nome = nome;
        this.end = end;
        this.ger = ger;
    }

    public Agencia()
    {
        
    }

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

    public void setNome(String n) {
        this.nome = n;
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
