import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GettingInfoAboutBookFromPage {
    private final String url;
    private WebDriver driver;
    private Book book = new Book();

    By findNameOfBook = By.cssSelector("span.a-size-extra-large");
    By findAuthorBook = By.cssSelector("a.contributorNameID");
    By findPriceBook = By.cssSelector("td.a-text-right.dp-used-col > span > a > span");
    By findNumberOfFeedBacks = By.id("acrCustomerReviewText");

    public GettingInfoAboutBookFromPage(String url, WebDriver driver){
        this.url = url;
        this.driver = driver;
        this.driver.navigate().to(url);
    }


    public Book getBookFromPage(){
        driver.findElement(By.xpath("//*[@id=\"mediaTab_heading_2\"]/a")).click();
        book.setName(driver.findElement(findNameOfBook).getText());
        book.setAuthor(driver.findElement(findAuthorBook).getText());
        book.setPrice(driver.findElement(findPriceBook).getText().replace("$", "").split("\\.", 2)[0]);
        book.setChekOnBestseller((Integer.parseInt(driver.findElement(findNumberOfFeedBacks).getText().replace(",", "").replace(" ratings", "")) > 400) ? "Bestseller" : "Not bestseller");
        return book;
    }


    public Book getBook() {
        return book;
    }
}
