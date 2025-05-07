import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//Entra no item b da 5, pois Dados não deve ser instanciada, só necessitamos dos métodos
public abstract class Dados {
    //leitura

    //leitura conta
    public static Object carregarObj(String arqNome) 
    {
        try (
            FileInputStream arq = new FileInputStream(arqNome);
            ObjectInputStream in = new ObjectInputStream(arq)
            ) 
        {
            
            return in.readObject();

        } catch (IOException | ClassNotFoundException e) 
        {
            System.out.println("Erro ao carregar o arquivo: " + e.getMessage());
            return null;
        }


    }

    public static void salvarObj(String arqNome, Object obj) 
    {
        try (FileOutputStream arq = new FileOutputStream(arqNome);
             ObjectOutputStream out = new ObjectOutputStream(arq)
            ) 
        {
            out.writeObject(obj);
        } catch (IOException e) 
        {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    //para buscar conta por numero e senha

    private static ArrayList<Conta> listaDeContas = new ArrayList<>();

    //para adicionar conta no banco
    public static void adicionarConta(Conta conta) {
        listaDeContas.add(conta);
    }

    //para mostrar a lista de contas
    public static ArrayList<Conta> getListaDeContas() {
        return listaDeContas;
    }

    public static Conta buscarContaPorNumero(int nroConta, int senha) {
        for (Conta conta : listaDeContas) {
            try {
                if (conta.getNroConta(senha) == nroConta) {
                    return conta;
                }
            } catch (SenhaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Conta nao encontrada");
        return null;
    }

    public static String promptStr(Scanner scan,String str)
    {
        System.out.println(str);
        return scan.nextLine();
    }

    public static int promptInt(Scanner scan,String str)
    {
        System.out.println(str);
        int res = scan.nextInt();
        scan.nextLine(); //consome o enter no buffer
        return res;
    }

    public static double promptDouble(Scanner scan,String str)
    {
        System.out.println(str);
        double res = scan.nextDouble();
        scan.nextLine(); //consome o enter no buffer
        return res;
    }
}
