package src.main;

import java.io.*;
import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Book> books;
    private Files files;


    public Library(String name) throws IOException {
        this.name=name;
        customers=new ArrayList<>();
        books=new ArrayList<>();
        files=new Files(this.name);
        start();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }


    public void addBook(Book book) {
        books.add(book);
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void start() throws IOException {
        refreshBooks();
        refreshCustomers();
        FileWriter fileWriter=new FileWriter(files.getSellingFile());
        PrintWriter printWriter=new PrintWriter(fileWriter);
        printWriter.println(name+"  Sellings");
        for(int i=0;i<66;i++){
            printWriter.print("-");
        }
        printWriter.println();
        //header
        printWriter.print("|");
        printWriter.print("         customer name          |");//9+13+10=32
        printWriter.print("        title       |");//8+5+7=20
        printWriter.println("   cost   |");//3+4+3=10

        printSeparatorLineForSellings(printWriter);

        printWriter.close();
        fileWriter.close();
    }
    private void printSeparatorLineForSellings(PrintWriter printWriter){
        //separator line
        printWriter.print("|");
        printWriter.print("--------------------------------|");//9+13+10=32
        printWriter.print("--------------------|");///8+5+7=20
        printWriter.println("----------|");//3+4+3=10
    }

    public void refreshbooks() throws IOException {
        FileWriter fileWriter = new FileWriter(files.getbooksFile());
        PrintWriter printWriter=new PrintWriter(fileWriter);
        printWriter.println(name+" books");
        for (int i=0; i<136 ; i++){
            printWriter.print("-");
        }
        printWriter.println();
        //header
        printWriter.print("|");
        printWriter.print(" ID |");//1+2+1
        printWriter.print("  Form  |");//2+6+2
        printWriter.print("        title       |");//8+5+7=20
        printWriter.print(" number of page |");//1+16+1=18
        printWriter.print("       author       |");//7+6+7
        printWriter.print("      type      |");//6+4+6=16
        printWriter.print("   cost   |");//3+4+3=10
        printWriter.print(" number of copies |");//1+16+1
        printWriter.println("     size     |");//5+4+5
        //separator line
        printSeparatorLineForBooks(printWriter);

       for(Book book:books) {
           printWriter.println(book.writeToFile());
           //separator line
           printSeparatorLineForBooks(printWriter);
       }

        printWriter.close();
        fileWriter.close();
    }

    private void printSeparatorLineForBooks(PrintWriter printWriter){
        //separator line
        printWriter.print("|");
        printWriter.print("----|");//1+2+1
        printWriter.print("--------|");//2+4+2
        printWriter.print("--------------------|");//8+5+7=20
        printWriter.print("----------------|");//1+16+1=18
        printWriter.print("--------------------|");//7+6+7=20
        printWriter.print("----------------|");//6+4+6=16
        printWriter.print("----------|");//3+4+3=11
        printWriter.print("------------------|");//1+16+1=18
        printWriter.println("--------------|");//5+4+5=14
    }

    public void refreshCustomers() throws IOException {
        FileWriter fileWriter=new FileWriter(files.getCustomersFile());
        PrintWriter printWriter=new PrintWriter(fileWriter);
        printWriter.println(name+" Customers");
        for(int i=0;i<102;i++){
            printWriter.print("-");
        }
        printWriter.println();
        //header
        printWriter.print("|");
        printWriter.print(" first name |");//1+10+1=12
        printWriter.print("  last name   |");//2+9+3=14
        printWriter.print("                address               |");//16+7+15=38
        printWriter.print(" balance  |");//1+7+2=10
        printWriter.println("       password       |");//7+8+7=22
        printSeparatorLineForCustomers(printWriter);

        for(Customer customer:customers) {
            printWriter.println(customer.writeToFile());
            //separator line
            printSeparatorLineForCustomers(printWriter);
        }

        printWriter.close();
        fileWriter.close();
    } 
    private void printSeparatorLineForCustomers(PrintWriter printWriter){
        //separator line
        printWriter.print("|");
        printWriter.print("------------|");//1+10+1=12
        printWriter.print("--------------|");//2+9+3=14
        printWriter.print("--------------------------------------|");//16+7+15=38
        printWriter.print("----------|");//1+7+2=10
        printWriter.println("----------------------|");//7+8+7
    }








    public void save() throws IOException {
        refreshCustomers();
        refreshBooks();
    }
    public Customer getCustomer(String name){
        for(Customer customer:customers){
            if((customer.getFirstName()+" "+customer.getLastName()).equals(name)) return customer;
        }
        return null;
    }

    public Book getBookByTitle(String title){
        for(Book book:books){
            if(book.getTitle().equals(title)) return book;
        }
        return null;
    }
    public ArrayList<Book> getBookByTitleAndType(String title,String type){
        ArrayList<Book> booksType=new ArrayList<>();
        for(Book book:books){
            if(book.getTitle().equals(title) && book.getType().equals(type)) booksType.add(book);
        }
        return booksType;
    }
    public Book getBookByTitleAndForm(String title,String form){
        for(Book book:books){
            if(book.getTitle().equals(title) && book.getForm().equalsIgnoreCase(form)) return book;
        }
        return null;
    }

    public void sellBook(String customerName,String bookTitle,String form) throws Exception {
        Customer customer=getCustomer(customerName);
        Book book=getBookByTitleAndForm(bookTitle,form);
        try
        {
            customer.buyBook(book);
        }
        catch (NullPointerException ex){
            System.out.println("wrong title or customer name");
            return;
        }
        String sellings="";
        FileReader fileReader=new FileReader(files.getSellingFile());
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String read=bufferedReader.readLine();
        while(read!=null){
            sellings+=read+"\n";
            read=bufferedReader.readLine();
        }
        fileReader.close();
        bufferedReader.close();


        FileWriter fileWriter=new FileWriter(files.getSellingFile());
        PrintWriter printWriter=new PrintWriter(fileWriter);

        printWriter.print(sellings);
        //header
        //------------------

        printWriter.print("|");

        int length=customerName.length();
        int spacesAfter=(32-length)/2;
        int spacesBefore= (length%2==0?spacesAfter:spacesAfter+1);

        for(int i=0;i<spacesBefore;i++){
            printWriter.print(" ");
        }

        printWriter.print(customerName);
        for(int i=0;i<spacesAfter;i++){
            printWriter.print(" ");
        }
        printWriter.print("|");
        //------------------

        length=bookTitle.length();
        spacesAfter=(20-length)/2;
        spacesBefore= (length%2==0?spacesAfter:spacesAfter+1);

        for(int i=0;i<spacesBefore;i++){
            printWriter.print(" ");
        }

        printWriter.print(bookTitle);
        for(int i=0;i<spacesAfter;i++){
            printWriter.print(" ");
        }
        printWriter.print("|");
//------------------

        length=String.valueOf(book.getPrice()).length();
        spacesAfter=(10-length)/2;
        spacesBefore= (length%2==0?spacesAfter:spacesAfter+1);

        for(int i=0;i<spacesBefore;i++){
            printWriter.print(" ");
        }

        printWriter.print(book.getPrice());
        for(int i=0;i<spacesAfter;i++){
            printWriter.print(" ");
        }
        printWriter.println("|");
        printSeparatorLineForSellings(printWriter);
        printWriter.close();
        fileWriter.close();
    }



    public void deleteCustomer(String customerName){
        Customer customer = getCustomer(customerName);
        if(customer == null){
            System.out.println("wrong customer name");
        }
        customers.remove(customer);
    }
    public void deleteBook(String title,String form){
        Book book = getBookByTitleAndForm(title,form);
        if(book==null){
            System.out.println("Wrong title or form");
            return;
        }
        books.remove(book);
    }
    void showType(String type){
        System.out.println("Books of type"+type+":" );
        int numberOfBooks=0;
        for(Book book : books){
            if(book.getType().equals(type)){
                System.out.println(book.getTitle()+": "+book.getForm());
                numberOfBooks++;
            }
        }
        if(numberOfBooks==0){
            System.out.println("no books of type "+type);
        }
    }

    //print all books in the library
    void showBooks() throws IOException {
        System.out.println("Books in our library:");
        FileReader fileReader=new FileReader(files.getBooksFile());
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line=bufferedReader.readLine();
        while(line!=null){
            System.out.println(line);
            line=bufferedReader.readLine();
        }
        fileReader.close();
        bufferedReader.close();
    }

    //print all books that the customer who logged in has bought
    void showCustomerBook(Customer customer){
        customer.printBooks();
    }
    public Customer login(String name,String password){
        for(Customer customer: getCustomers()){
            if((customer.getFirstName()+customer.getLastName()).equals(name) && customer.getPassword().equals(password)) return customer;
        }
        return null;
    }

    
    }

        
    
