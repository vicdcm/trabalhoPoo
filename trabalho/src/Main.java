import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList <Conta> contas =  new ArrayList<>(); //lista de arrays para salvar os objetos
        ArrayList<Cliente> clientes =  new ArrayList<>(); 
        ArrayList<Endereco> enderecos = new ArrayList<>();
        ArrayList<Agencia> agencias = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();


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

Gerente gerente1 = new Gerente(
        "Carlos Silva",
        "Casado",
        "15/03/1980",
        "111.222.333-44",
        end1,
        "Masculino",
        "9346124/8778",
        "5304578892",
        15000.0f,
        "12/05/2008",
        true
        );
funcionarios.add(gerente1);

Gerente gerente2 = new Gerente(
        "Ana Costa",
        "Solteira",
        "20/08/1990",
        "555.666.777-88",
        end1,
        "Feminino",
        "6438468/2414",
        "9732452567",
        12000.0f,
        "12/12/2020",
        false
);
funcionarios.add(gerente2);

Gerente gerente3 = new Gerente(
        "Paulo Carlos",
        "Solteiro",
        "20/10/1975",
        "434.598.737-99",
        end3,
        "Masculino",
        "4378918/7834",
        "872478249",
        23000.0f,
        "03/07/2000",
        true
);
funcionarios.add(gerente3);

Gerente.setComissao(0.05f);

        Agencia agenciaCentral = new Agencia(
                1,
                "Agencia Central SP",
                end1,
                gerente1
        );
        agencias.add(agenciaCentral);

        Agencia agenciaCopacabana = new Agencia(
                2,
                "Agencia Copacabana",
                end2,
                gerente2
        );
        agencias.add(agenciaCopacabana);

        Agencia agenciaBH = new Agencia(
                3,
                "Agencia Belo Horizonte",
                end3,
                gerente3
        );
        agencias.add(agenciaBH);


        //Menu principal, pensei no código em sempre termos as mesmas agencias e gerentes, só rotacionando as contas e clientes
        System.out.println(
                "<<< Menu Principal >>>" +
                "\n" +
                "\nBem vindo! O que gostaria de fazer?" +
                "\n[1]Acessar Conta" +
                "\n[2]Verificar uma Agencia" +
                "\n"
        );
        int op;
        do {
            op = Dados.promptInt(scan, "Digite o numero: ");
        } while (op < 1 || op > 2);

        if(op == 1) {
            //operações...
        }
        else {
            System.out.println(
                    "Qual agencia voce quer verificar?" +
                    "\n[1]De Sao Paulo" +
                    "\n[2]De Copacabana" +
                    "\n[3]De Belo Horizonte" +
                    "\n"
            );
            do {
                op = Dados.promptInt(scan, "Digite o numero: ");
            } while (op < 1 || op > 3);
            System.out.println((agencias.get(op-1)).toString());
        }


          /*
          switch (op) {

            case 1:  //teste para criar uma agencia
            String buscaCpf = Dados.promptStr(scan,"digite o cpf do gerente da agencia:");
            Gerente buscaF = (Gerente) Funcionario.encontraFuncionario(funcionarios, buscaCpf);

            if(buscaF==null)
            {
                System.out.println("funcionario não encontrado");
                break;
            }
            else
            {
                int num = Dados.promptInt(scan,"digite o numero da agencia");
                String nome = Dados.promptStr(scan, "digite o nome da agencia");
                Endereco end = Endereco.criaEnd(scan);
                Agencia novaAg = new Agencia(num, nome, end, gerente1);
            } 
                break;
          
            default:
                break;
          }
        */

        
    }
}