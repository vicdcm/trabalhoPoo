import java.io.*;
public class Dados {
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
}
