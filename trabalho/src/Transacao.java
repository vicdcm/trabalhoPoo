import java.io.Serializable;
public class Transacao implements Serializable{
    private String data, canal, tipo;
    private float val;
    private Conta conta;
    private boolean ocorreu;

    //Construtor somente por causa do requisitado no enunciado
    public Transacao(Conta conta, String data) {
        this.conta = conta;
        this.data = data;
    }

    //construtor que recebe como parametro a conta e a data
    public Transacao(Conta conta, String tipo, float val, String canal) {
        this.conta = conta;
        this.tipo = tipo.toLowerCase();
        this.val = val;
        this.canal = canal;
        this.data = Conta.dataAtual();
        this.ocorreu = false;
    }

//gets e sets
public String getdata() {
    return data;
}
public void setdata(String data) {
    this.data = data;
}
public float getval() {
    return val;
}
public void setval(float val) {
    this.val = val;
}
public void setOcorreu(boolean oc) {
        ocorreu = oc;
}
}
