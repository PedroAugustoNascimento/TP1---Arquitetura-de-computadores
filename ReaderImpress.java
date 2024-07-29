import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReaderImpress{

     //Read the .txt file
    public static void readImpress(String path) { 
        String binary = "", all = "";
        try {
            FileReader archive = new FileReader(path);
            BufferedReader readArchive = new BufferedReader(archive);

            String line = readArchive.readLine();
            
            while (line != null) { 
               binary = Formater.check(line);
                all += binary + "\n";
                 line = readArchive.readLine();    
            }
               
            archive.close();
       } catch (IOException e) {
            System.err.printf("Arquivo não encontrado: %s.\n",
                      e.getMessage());
       }

       //Impress the .txt with final results
        try { 
               BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\pakkz\\OneDrive\\Documentos\\TP1 - Arquitetura de Computadores\\Resultado do txt\\result.txt"));
               bufferedWriter.write(all, 0, all.length());
               bufferedWriter.close();
          } catch (Exception e) {
               e.printStackTrace();
          }
    }
}