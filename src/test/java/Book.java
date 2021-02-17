

public class Book {
    private String name;
    private String author;
    private String price;
    private String chekOnBestseller;

    public String getName() {
        return name;
    }

    public Book(String name, String author, String price, String chekOnBestseller) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.chekOnBestseller = chekOnBestseller;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String isChekOnBestseller() {
        return chekOnBestseller;
    }

    public void setChekOnBestseller(String chekOnBestseller) {
        this.chekOnBestseller = chekOnBestseller;
    }

    @Override
    public String toString() {
        return "Book ------------------------ \n" + "\tName: " + name + "\n" + "\tAuthor: " + author + "\n" + "\tPrice: " + price + "\n" + "\tBestseller: " + chekOnBestseller;
    }
}
