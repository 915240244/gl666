package net.nice.bean;

public class Book {
    private Integer book_ID;
    private String title;
    private String author;
    private String press;
    private String location;
    private Integer type_Number;
    private String url;
    private String publication_Date;
    private double price;
    private Integer total;
    private Integer stocks;
    private String synopsis;




    public Integer getBook_ID() {
        return book_ID;
    }

    public void setBook_ID(Integer book_ID) {
        this.book_ID = book_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public Integer getType_Number() {
        return type_Number;
    }

    public void setType_Number(Integer type_Number) {
        this.type_Number = type_Number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublication_Date() {
        return publication_Date;
    }

    public void setPublication_Date(String publication_Date) {
        this.publication_Date = publication_Date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStocks() {
        return stocks;
    }

    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", book_ID='" + book_ID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", location='" + location + '\'' +
                ", type_Number=" + type_Number +
                ", url='" + url + '\'' +
                ", publication_Date='" + publication_Date + '\'' +
                ", price=" + price +
                ", total=" + total +
                ", stocks=" + stocks +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }

}
