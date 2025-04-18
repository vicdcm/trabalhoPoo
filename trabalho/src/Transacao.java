public class Transacao {
    private String data, canal, tipo;
    private float val;
    private Conta conta;




    //construtor que recebe como parametro a conta e a data
    public Transacao(Conta conta, String tipo, float val, String canal) {
        this.conta = conta;
        this.tipo = tipo.toLowerCase();
        this.val = val;
        this.canal = canal;
        this.data = Conta.dataAtual();
        aplicarTransacao();
    }

    private void aplicarTransacao() {
        switch (tipo) {
            case "deposito":
                conta.setSaldo(conta.getSaldo() + val);
                break;
            case "saque":
            case "pagamento":
                if (conta.getSaldo() >= val) {
                    conta.setSaldo(conta.getSaldo() - val);
                } else {
                    System.out.println("Saldo insuficiente para " + tipo);
                }
                break;
            case "consulta":
                System.out.println("Saldo atual: " + conta.getSaldo());
                break;
            default:
                System.out.println("Tipo de transação inválido");
        }
        // Falta inserir no array de transações

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
}
