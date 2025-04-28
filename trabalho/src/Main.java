import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // listas para armazenar os objetos 
        ArrayList<Conta> contas = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Endereco> enderecos = new ArrayList<>();
        ArrayList<Agencia> agencias = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        // cadastrando endereços 
        Endereco end1 = new Endereco("SP", "São Paulo", "Centro", "Avenida Paulista", 1000);
        Endereco end2 = new Endereco("RJ", "Rio de Janeiro", "Copacabana", "Rua Barata Ribeiro", 200);
        Endereco end3 = new Endereco("MG", "Belo Horizonte", "Savassi", "Rua da Bahia", 500);

        // cadastrando gerentes 
        Gerente gerente1 = new Gerente("Carlos Silva", "Casado", "15/03/1980", "111.222.333-44", end1, "Masculino", "9346124/8778", "5304578892", 15000.0f, "12/05/2008", true);
        Gerente gerente2 = new Gerente("Ana Costa", "Solteira", "20/08/1990", "555.666.777-88", end1, "Feminino", "6438468/2414", "9732452567", 12000.0f, "12/12/2020", false);
        Gerente gerente3 = new Gerente("Paulo Carlos", "Solteiro", "20/10/1975", "434.598.737-99", end3, "Masculino", "4378918/7834", "872478249", 23000.0f, "03/07/2000", true);

        funcionarios.add(gerente1);
        funcionarios.add(gerente2);
        funcionarios.add(gerente3);

        Gerente.setComissao(0.05f);

        // criando agências
        agencias.add(new Agencia(1, "Agência Central SP", end1, gerente1));
        agencias.add(new Agencia(2, "Agência Copacabana", end2, gerente2));
        agencias.add(new Agencia(3, "Agência Belo Horizonte", end3, gerente3));

        while (true) {
            System.out.println("<<< Menu Principal >>>\n");
            System.out.println("[1] Acessar Conta");
            System.out.println("[2] Verificar uma Agência");
            System.out.println("[3] Encerrar o Programa");
            System.out.println("[4] Criar Nova Agência"); // <-- nova opção aqui

            int op = Dados.promptInt(scan, "Digite o número: ");

            switch (op) {
                case 1:
                    acessarConta(scan, contas, agencias);
                    break;
                case 2:
                    verificarAgencia(scan, agencias);
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    return;
                case 4:
                    criarNovaAgencia(scan, funcionarios, agencias);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // metodo para acessar contas, separado do main
    private static void acessarConta(Scanner scan, ArrayList<Conta> contas, ArrayList<Agencia> agencias) {
        System.out.println("Digite o número da conta que deseja acessar:");
        int numeroConta = Dados.promptInt(scan, "Número da conta: ");
        System.out.println("Digite a senha da conta:");
        int senha = Dados.promptInt(scan, "Senha: ");

        Conta conta = Banco.buscarContaPorNumero(numeroConta, senha);

        if (conta != null) {
            acessarMenuConta(scan, conta);
        } else {
            System.out.println("Conta não encontrada ou senha incorreta.");
            System.out.println("[1] Voltar ao menu anterior\n[2] Cadastrar nova conta");

            int escolha = Dados.promptInt(scan, "Digite o número: ");
            if (escolha == 2) {
                cadastrarConta(scan, contas, agencias);
            }
        }
    }

    // metodo separado para interagir com a conta 
    private static void acessarMenuConta(Scanner scan, Conta conta) {
        while (true) {
            System.out.println("<<< Conta >>>");
            System.out.println("[1] Sacar");
            System.out.println("[2] Depositar");
            System.out.println("[3] Ver saldo");
            System.out.println("[4] Voltar");

            int op = Dados.promptInt(scan, "Escolha: ");
            switch (op) {
                case 1:
                    double valorSaque = Dados.promptDouble(scan, "Valor do saque: ");
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado!");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 2:
                    double valorDeposito = Dados.promptDouble(scan, "Valor do depósito: ");
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito feito com sucesso!");
                    break;
                case 3:
                    System.out.println("Saldo: R$ " + conta.getSaldo());
                    break;
                case 4:
                    return; // ok
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // novo metodo para o cadastro de contas
    private static void cadastrarConta(Scanner scan, ArrayList<Conta> contas, ArrayList<Agencia> agencias) {
        System.out.println("Cadastro de nova conta:");

        int nroConta = Dados.promptInt(scan, "Número da nova conta: ");
        int senha = Dados.promptInt(scan, "Senha da nova conta: ");
        double saldo = Dados.promptDouble(scan, "Saldo inicial: ");

        System.out.println("Escolha a agência:");
        for (int i = 0; i < agencias.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + agencias.get(i).getNome());
        }
        int indiceAgencia = Dados.promptInt(scan, "Digite o número da agência: ") - 1;

        Agencia agSelecionada = agencias.get(indiceAgencia);

        String nomeCliente = Dados.promptStr(scan, "Nome do cliente: ");
        String cpfCliente = Dados.promptStr(scan, "CPF do cliente: ");
        Cliente cliente = new Cliente(nomeCliente, cpfCliente);

        double limiteChequeEspecial = Dados.promptDouble(scan, "Limite do cheque especial: ");
        double taxaAdministrativa = Dados.promptDouble(scan, "Taxa administrativa: ");

        ContaCorrente novaConta = new ContaCorrente(senha, nroConta, agSelecionada, saldo, cliente, limiteChequeEspecial, taxaAdministrativa);
        Banco.adicionarConta(novaConta);
        Banco.salvarContasEmArquivo("contas_01.dat");

        System.out.println("Conta cadastrada com sucesso!");
    }

    // metodo para consultar as agências
    private static void verificarAgencia(Scanner scan, ArrayList<Agencia> agencias) {
        System.out.println("Escolha a agência para visualizar:");
        for (int i = 0; i < agencias.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + agencias.get(i).getNome());
        }
        int escolha = Dados.promptInt(scan, "Digite o número: ") - 1;
        System.out.println(agencias.get(escolha));
    }

    // metodo para criar nova agência
    private static void criarNovaAgencia(Scanner scan, ArrayList<Funcionario> funcionarios, ArrayList<Agencia> agencias) {
        System.out.println("<<< Criação de Nova Agência >>>");

        String buscaCpf = Dados.promptStr(scan, "Digite o CPF do gerente da agência:");

        // busca direta por Gerente
Gerente buscaF = null;
for (Funcionario f : funcionarios) {
    if (f instanceof Gerente) {
        Gerente gerente = (Gerente) f; // cast para Gerente
        if (gerente.getcpf().equals(buscaCpf)) {  
            buscaF = gerente;
            break;
        }
    }
}

        // verifica se encontrou o gerente
        if (buscaF == null) {
            System.out.println("Funcionário não encontrado.");
        } else {
            int num = Dados.promptInt(scan, "Digite o número da agência: ");
            String nome = Dados.promptStr(scan, "Digite o nome da agência: ");
            Endereco end = Endereco.criaEnd(scan); 

            // cria a nova agência com o gerente encontrado
            Agencia novaAg = new Agencia(num, nome, end, buscaF);
            agencias.add(novaAg); // add nova agencia a lista
            System.out.println("Agência criada com sucesso!");
        }
    }
}
