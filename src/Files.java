package src;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Files {
    private File booksFile;
    private File customersFile;

    private File sellingFile;

    public Files(){
        booksFile=new File("books.txt");
        customersFile=new File("customers.txt");

        sellingFile=new File("sellings.txt");

    }

    public Files( String LibraryName) throws IOException {
        FileWriter f = new FileWriter(LibraryName+"books.txt");

        booksFile=new File(LibraryName+"books.txt");
        customersFile= new File(LibraryName+"Customers.txt");
        sellingFile = new File(LibraryName+"Sellings.txt");

    }

    public File getBookFile() {
        return booksFile;
    }

    public File getCustomersFile() {
        return customersFile;
    }

    public File getSellingFile() {
        return sellingFile;
    }

    }
