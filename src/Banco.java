import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;


public class Banco {
    private static ArrayList<Conta> listaDeContas = new ArrayList<>();

    //para adicionar conta no banco
    public static void adicionarConta(Conta conta) {
        listaDeContas.add(conta);
    }

    //para mostrar a lista de contas
    public static ArrayList<Conta> getListaDeContas() {
        return listaDeContas;
    }

    // para buscar conta pelo número e senha
    public static Conta buscarContaPorNumero(int nroConta, int senha) {
        double buffer;
        for (Conta conta : listaDeContas) {
            try {
                if (conta.getNroConta() == nroConta) {
                    buffer = conta.getSaldo(senha);
                    return conta;
                }
            } catch (SenhaInvalidaException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        System.out.println("Conta nao encontrada");
        return null;
    }

    public static void salvarContasEmArquivo(String nomeArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(listaDeContas);
            System.out.println("Contas salvas com sucesso");
        } catch (IOException e) {
            System.out.println("Erro ao salvar contas: " + e.getMessage());
        }
    }

    public static void carregarContasDeArquivo(String nomeArquivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaDeContas = (ArrayList<Conta>) in.readObject();
            System.out.println("Contas carregadas com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar contas: " + e.getMessage());
        }
    }

}
