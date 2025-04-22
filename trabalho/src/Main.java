import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        ArrayList <Conta> contas =  new ArrayList<>(); //lista de arrays para salvar os objetos
        ArrayList<Cliente> clientes =  new ArrayList<>(); 
        ArrayList<Endereco> enderecos = new ArrayList<>();
        ArrayList<Agencia> agencias = new ArrayList<>();


        /* 
        clientes = (ArrayList<Cliente>) Dados.carregarObj("clientes.dat");

        


        Endereco endereco1 = new Endereco();
endereco1.setEstado("SP");
endereco1.setCidade("São Paulo");
endereco1.setRua("Avenida Paulista");
endereco1.setNum(1000);
enderecos.add(endereco1); 

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
     
    System.out.println(clientes.isEmpty());
         Dados.salvarObj("clientes.dat", clientes); 
          */

    Endereco end1 = new Endereco("SP","São Paulo","Centro","Avenida Paulista",1000);
    Endereco end2 = new Endereco("RJ","rio de janeiro","copacabana","rua barata ribeiro",200);
    Endereco end3 = new Endereco("MG","belo horizonte","savassi","rua da bahia",500);
        
Gerente gerente1 = new Gerente();
gerente1.setNome("Carlos Silva");
gerente1.setcpf("111.222.333-44");
gerente1.setDataNasc("15/03/1980");
gerente1.setEstadoCiv("Casado");
gerente1.setEndereco(end1); 
gerente1.setSexo("Masculino");
gerente1.setCargo("Gerente Geral");
gerente1.setSalario(15000.0f);
gerente1.setAnoIngresso(2015);
gerente1.setTemFormacaoBasica(true);


Gerente gerente2 = new Gerente();
gerente2.setNome("Ana Costa");
gerente2.setcpf("555.666.777-88");
gerente2.setDataDeNascimento("20/08/1990");
gerente2.setEstadoCiv("Solteira");
gerente2.setEndereco(end2); 
gerente2.setSexo("Feminino");
gerente2.setCargo("Gerente Regional");
gerente2.setSalario(12000.0f);
gerente2.setAnoIngresso(2020);
gerente2.setTemFormacaoBasica(false);


Gerente.setComissao(0.05f); // 5% commission     


Agencia agenciaCentral = new Agencia();
agenciaCentral.setNum(1);
agenciaCentral.setNome("Agência Central SP");
agenciaCentral.setEnd(end1); // São Paulo address
agenciaCentral.setGer(gerente1); // Assign gerente1


Agencia agenciaCopacabana = new Agencia();
agenciaCopacabana.setNum(2);
agenciaCopacabana.setNome("Agência Copacabana");
agenciaCopacabana.setEnd(end2); 
agenciaCopacabana.setGer(gerente2); 

        int op = 1;

          switch (op) {
            case 1:  //teste para criar uma agencia


                
                break;
          
            default:
                break;
          }


        
    }
}