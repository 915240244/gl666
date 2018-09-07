package net.nice.bean;



public class AdminBook {
    private  String Book_ID;
    private  String  Title ;
    private  String  Author ;
    private  String  press ;
    private  String  location ;
    private  int   Type_Number;
    private  String  url;
    private String publication_Date;
    private float price;
    private  int Total;
    private  int Stocks;
    private String  Synopsis;


    public AdminBook() {
    }

    public AdminBook(String title, String author, String press, String location, int type_Number, String url, String publisher_Date, float price, int total, int stocks, String synopsis) {
        Title = title;
        Author = author;
        this.press = press;
        this.location = location;
        Type_Number = type_Number;
        this.url = url;
        publication_Date = publication_Date;
        this.price = price;
        Total = total;
        Stocks = stocks;
        Synopsis = synopsis;
    }

    public AdminBook(String book_ID, String title, String author, String press, String location, int type_Number, String url, String publication_Date, float price, int total, int stocks, String synopsis) {
        Book_ID = book_ID;
        Title = title;
        Author = author;
        this.press = press;
        this.location = location;
        Type_Number = type_Number;
        this.url = url;
        publication_Date = publication_Date;
        this.price = price;
        Total = total;
        Stocks = stocks;
        Synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "AdminBook{" +
                "Book_ID='" + Book_ID + '\'' +
                ", Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", press='" + press + '\'' +
                ", location='" + location + '\'' +
                ", Type_Number=" + Type_Number +
                ", url='" + url + '\'' +
                ", publisher_Date='" + publication_Date + '\'' +
                ", price=" + price +
                ", Total=" + Total +
                ", Stocks=" + Stocks +
                ", Synopsis='" + Synopsis + '\'' +
                '}';
    }

    public String getBook_ID() {
        return Book_ID;
    }

    public void setBook_ID(String book_ID) {
        Book_ID = book_ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getType_Number() {
        return Type_Number;
    }

    public void setType_Number(int type_Number) {
        Type_Number = type_Number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getpublication_Date() {
        return publication_Date;
    }

    public void setPublisher_Date(String publication_Date) {
        this.publication_Date = publication_Date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public int getStocks() {
        return Stocks;
    }

    public void setStocks(int stocks) {
        Stocks = stocks;
    }

    public String getSynopsis() {
        return Synopsis;
    }

    public void setSynopsis(String synopsis) {
        Synopsis = synopsis;
    }
}
