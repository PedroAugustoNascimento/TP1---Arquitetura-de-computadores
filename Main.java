import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        //Path is the archive local
        String path;
        System.out.println("Insert the file path to init the conversion: ");
        path = read.nextLine();
        read.close();
        ReaderImpress.readImpress(path);
    }
}
