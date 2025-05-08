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



        Gerente.setComissao(0.05f);

        // Carregar dados de arquivos
        contas = (ArrayList<Conta>)Dados.carregarObj("contas_01.dat");
        clientes = (ArrayList<Cliente>)Dados.carregarObj("clientes.dat");
        enderecos = (ArrayList<Endereco>)Dados.carregarObj("enderecos.dat");
        agencias = (ArrayList<Agencia>)Dados.carregarObj("agencias.dat");
        funcionarios = (ArrayList<Funcionario>)Dados.carregarObj("funcionarios.dat");
        // Adiciona as contas ao banco
        for (Conta conta : contas) {
            Banco.adicionarConta(conta);
        }
        // Adiciona os clientes ao banco



        while (true) {
            System.out.println("<<< Menu Principal >>>\n");
            System.out.println("[1] Acessar Conta");
            System.out.println("[2] Verificar uma Agência");
            System.out.println("[3] Cadastrar uma conta");
            System.out.println("[4] Encerrar o Programa");
            System.out.println("[5] Criar Nova Agência");

            int op = Dados.promptInt(scan, "Digite o número: ");

            switch (op) {
                case 1:
                    acessarConta(scan, contas, agencias);
                    break;
                case 2:
                    verificarAgencia(scan, agencias);
                    break;
                case 3:
                    cadastrarConta(scan, contas, agencias);
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    Dados.salvarObj("clientes.dat", clientes);
                    Dados.salvarObj("enderecos.dat", enderecos);
                    Dados.salvarObj("agencias.dat", agencias);
                    Dados.salvarObj("funcionarios.dat", funcionarios);

                    return;
                case 5:
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
            acessarMenuConta(scan, conta, senha);
        } else {
            System.out.println("[1] Voltar ao menu anterior\n[2] Cadastrar nova conta");

            int escolha = Dados.promptInt(scan, "Digite o número: ");
            if (escolha == 2) {
                cadastrarConta(scan, contas, agencias);
            }
        }
    }

    // metodo separado para interagir com a conta 
    private static void acessarMenuConta(Scanner scan, Conta conta, int senha) {
        while (true) {
            mostrarResumoClientes(conta, senha);
            if(conta.getEstaAtiva(senha)) System.out.println("<<< Conta >>>");
            else System.out.println("<<< Conta (desativada) >>>");
            System.out.println("[1] Sacar");
            System.out.println("[2] Depositar");
            System.out.println("[3] Ver saldo");
            System.out.println("[4] Desativar conta");
            System.out.println("[5] Ver mais dados");
            System.out.println("[6] Voltar");

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
                    System.out.println("Tem certeza?\n[1]Sim\n[2]Nao");
                    op = Dados.promptInt(scan, "Escolha: ");
                    if(op < 1 || op > 2) System.out.println("Opção inválida.");
                    else if(op == 1) conta.setEstaAtiva(false, senha);
                    else System.out.println("Ok, voltando...");
                case 5:
                    System.out.println("Número da conta: " + conta.getNroConta());
                    System.out.println("Data de abertura: " + conta.getDataAbertura(senha));
                    System.out.print("Data da última transação: ");
                    System.out.println(conta.getDataUltima(senha));
                    System.out.println("Agência: " + conta.getAg(senha).getNome());
                    break;
                case 6:
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

        ArrayList<Cliente> clientes = new ArrayList<>();
        String nomeCliente = Dados.promptStr(scan, "Nome do cliente: ");
        String cpfCliente = Dados.promptStr(scan, "CPF do cliente: ");
        Cliente cliente = new Cliente(nomeCliente, cpfCliente);
        clientes.add(cliente);
        int op;
        while(true) {
            System.out.println("Mais algum cliente?\n[1]Sim\n[2]Nao");
            op = Dados.promptInt(scan, "Escolha: ");
            if(op == 2) break;
            else if(op == 1) {
                nomeCliente = Dados.promptStr(scan, "Nome do cliente: ");
                cpfCliente = Dados.promptStr(scan, "CPF do cliente: ");
                cliente = new Cliente(nomeCliente, cpfCliente);
                clientes.add(cliente);
            } else System.out.println("Opcao invalida");
        }

        System.out.println("Que tipo de conta deseja criar? ");
        System.out.println("[1] Corrente");
        System.out.println("[2] Poupanca");
        System.out.println("[3] Salario");

        op = Dados.promptInt(scan, "Escolha: ");
        switch (op) {
            case 1:

                double limiteChequeEspecial = Dados.promptDouble(scan, "Limite do cheque especial: ");
                double taxaAdministrativa = Dados.promptDouble(scan, "Taxa administrativa: ");

                ContaCorrente novaConta = new ContaCorrente(senha, nroConta, agSelecionada, saldo, cliente, limiteChequeEspecial, taxaAdministrativa);
                Banco.adicionarConta(novaConta);
                Banco.salvarContasEmArquivo("contas_01.dat");

                System.out.println("Conta cadastrada com sucesso!");
                break;
            case 2:
                double RendimentoMesAtual = Dados.promptDouble(scan, "Rendimento mensal: ");

                ContaPoupanca novaContap = new ContaPoupanca(senha, nroConta, agSelecionada, saldo, cliente, RendimentoMesAtual);
                Banco.adicionarConta(novaContap);
                Banco.salvarContasEmArquivo("contas_01.dat");

                System.out.println("Conta cadastrada com sucesso!");
                break;
            case 3:
                double limSaque = Dados.promptDouble(scan, "Limite de saque: ");
                double limTransacao = Dados.promptDouble(scan, "Limite de Transacao: ");

                ContaSalario novaContaS = new ContaSalario(senha, nroConta, agSelecionada, saldo, cliente, limSaque, limTransacao);
                Banco.adicionarConta(novaContaS);
                Banco.salvarContasEmArquivo("contas_01.dat");

                System.out.println("Conta cadastrada com sucesso!");
                break;
            default:
                System.out.println("Opção inválida.");

        }
    }

    //metodo para mostrar informações do cliente
    private static void mostrarResumoClientes(Conta conta, int senha) {
        try {
            ArrayList<Cliente> clientes = conta.getClientes(senha);
            for (Cliente c : clientes) {
                System.out.println("Nome: " + c.getNome());
                System.out.println("CPF: " + c.getcpf());
            }
        } catch (SenhaInvalidaException e) {
            System.out.println("Erro ao acessar dados do cliente: " + e.getMessage());
        }
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
