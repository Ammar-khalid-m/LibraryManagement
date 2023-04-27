package src.main;
public abstract class Book {
    private int bookNumber;
    private static int nextNumber=1;
    private String Title;
    private int numberOfPages;
    private String author;
    private String type;
    protected double price;

    public Book(){}

    public Book(String title, int numberOfPages,String author, String type, double price) {
        bookNumber=nextNumber++;
        Title = title;
        this.numberOfPages=numberOfPages;
        this.author = author;
        this.type = type;
        this.price = price;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public abstract double getPrice();

    public abstract void sell() throws Exception;

    @Override
    public String toString() {
        return "bookNumber: " + bookNumber +
                ", Title: " + Title +
                ", numberOfPages: " + numberOfPages +
                ", author: " + author +
                ", type: " + type  +
                ", price: " + price;
    }

    public String writeToFile(){
        String line="";
        line+="|";
        //------------------
        int length=String.valueOf(bookNumber).length();
        int spacesAfter=(4-length)/2;
        int spacesBefore= (length%2==0?spacesAfter:spacesAfter+1);
        for(int i=0;i<spacesBefore;i++){
            line+=" ";
        }
        line+=bookNumber;
        for(int i=0;i<spacesAfter;i++){
            line+=" ";
        }
        line+='|';
        //------------------
        length=getForm().length();
        spacesAfter=(8-length)/2;
        spacesBefore= (length%2==0?spacesAfter:spacesAfter+1);

        for(int i=0;i<spacesBefore;i++){
            line+=" ";
        }

        line+=getForm();
        for(int i=0;i<spacesAfter;i++){
            line+=" ";
        }

        line+="|";
        //------------------
        length=Title.length();
        spacesAfter=(20-length)/2;
        spacesBefore= (length%2==0?spacesAfter:spacesAfter+1);

        for(int i=0;i<spacesBefore;i++){
            line+=" ";
        }

        line+=Title;
        for(int i=0;i<spacesAfter;i++){
            line+=" ";
        }

        line+="|";
        //------------------
        length=String.valueOf(numberOfPages).length();
        spacesAfter=(16-length)/2;
        spacesBefore= (length%2==0?spacesAfter:spacesAfter+1);
        for(int i=0;i<spacesBefore;i++){
            line+=" ";
        }
        line+=numberOfPages;
        for(int i=0;i<spacesAfter;i++){
            line+=" ";
        }
        line+="|";
        //------------------
        length=author.length();
        spacesAfter=(20-length)/2;
        spacesBefore= (length%2==0?spacesAfter:spacesAfter+1);

        for(int i=0;i<spacesBefore;i++){
            line+=" ";
        }

        line+=author;
        for(int i=0;i<spacesAfter;i++){
            line+=" ";
        }

        line+="|";
        //------------------
        length=type.length();
        spacesAfter=(16-length)/2;
        spacesBefore= (length%2==0?spacesAfter:spacesAfter+1);

        for(int i=0;i<spacesBefore;i++){
            line+=" ";
        }

        line+=type;
        for(int i=0;i<spacesAfter;i++){
            line+=" ";
        }

        line+="|";
        //------------------
        length=String.valueOf(getPrice()).length();
        spacesAfter=(10-length)/2;
        spacesBefore= (length%2==0?spacesAfter:spacesAfter+1);
        for(int i=0;i<spacesBefore;i++){
            line+=" ";
        }
        line+=getPrice();
        for(int i=0;i<spacesAfter;i++){
            line+=" ";
        }
        line+="|";
        return line;
    }

    public abstract String getForm();//Paper, PDF or Audio
}