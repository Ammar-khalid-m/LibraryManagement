package src.main;

public class PaperBook extends Book{

    private int numberOfCopies;

    public PaperBook(){}
    public PaperBook(String title, int numberOfPages, String author, String type, double price, int numberOfCopies) {
        super(title,numberOfPages, author, type, price);
        this.numberOfCopies = numberOfCopies;
    }



    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void addCopies(int numberOfCopies){
        this.numberOfCopies=this.numberOfCopies+numberOfCopies;
    }

    @Override
    public double getPrice() {
        //price is the same price
        return price;
    }

    @Override
    public void sell() throws Exception {
        if(numberOfCopies==0) throw new Exception();
        numberOfCopies--;
        //this function decreases numberOfCopies or throw exception if there is no more copies
        //but if we tried to sell an unavailable book we will call this method by null which will throw NullPointerException
        //catching NullPointerException means we sell an unavailable book
    }

    @Override
    public String toString() {
        return "PaperBook: " +super.toString()+
                "numberOfCopies: " + numberOfCopies;
    }

    @Override
    public String getForm() {//Paper
        return "Paper";
    }
    
    // to be continued...