import java.util.ArrayList;


/* adicionei funções gets e sets em algumas classes, mudei o encapsulamento de alguns atributos que estavam publicos para protected ou private 
 * criei uma função estatica na classe de clientes que realiza uma busca em um vetor procurando um cliente com um cpf especifico
 * na função main tem um teste de busca de clientes
 * 
 */

public class Main {
    public static void main(String[] args) {

        ArrayList <Conta> contas =  new ArrayList<>(); //lista de arrays para salvar os objetos
        ArrayList<Cliente> clientes =  new ArrayList<>(); 
        ArrayList<Endereco> enderecos = new ArrayList<>();
        ArrayList<Agencia> agencias = new ArrayList<>();

        Boolean test = Pessoa.validaCPF("131.031.666-04");

        String teste = Conta.dataAtual();

        Endereco endereco1 = new Endereco();
endereco1.setEstado("SP");
endereco1.setCidade("São Paulo");
endereco1.setRua("Avenida Paulista");
endereco1.setNum(1000);
enderecos.add(endereco1); // Add to local list

Endereco endereco2 = new Endereco();
endereco2.setEstado("RJ");
endereco2.setCidade("Rio de Janeiro");
endereco2.setRua("Copacabana");
endereco2.setNum(200);
enderecos.add(endereco2);

Agencia agencia1 = new Agencia();
    agencia1.setNum(1);
    agencia1.setNome("Agência Central");
    agencia1.setEnd(endereco1);
    agencias.add(agencia1);

    
    Agencia agencia2 = new Agencia();
    agencia2.setNum(2);
    agencia2.setNome("Agência Copacabana");
    agencia2.setEnd(endereco2);
    agencias.add(agencia2);

    Cliente cliente1 = new Cliente();
    cliente1.setNome("João Silva");
    cliente1.setcpf("123.456.789-00");
    cliente1.setAgencia(agencia1);
    cliente1.setEndereco(endereco1);
    clientes.add(cliente1);

    Cliente cliente2 = new Cliente();
    cliente2.setNome("Maria Souza");
    cliente2.setcpf("987.654.321-00");
    cliente2.setAgencia(agencia2);
    cliente2.setEndereco(endereco2);
    clientes.add(cliente2);
    
    Cliente busca = Cliente.encontraCliente(clientes,"987.654.321-00");
    Cliente busca1 = Cliente.encontraCliente(clientes,"123.456.789-00");


        System.out.println("Hello, World! " + test +" " +teste+ " "+busca.nome+" "+busca1.nome);
    }
}