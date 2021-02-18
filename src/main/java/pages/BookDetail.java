package pages;

import elements.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class BookDetail {
    public final String url;
    private final WebDriver driver;
    private final Book book = new Book();

    String findNameOfBook = "//div[contains(@id,\"dp-container\")]//div[contains(@id, 'titleblock_feature_div')]//h1[contains(@id, 'title')]/span[contains(@id, 'productTitle')]";
    String findAuthorBook = "//div[contains(@id, 'bylineInfo_feature_div')]//span/a[contains(@class, 'a-link-normal contributorNameID')]";
    String findPriceBook = "//div[contains(@id, 'buybox')]/div/div//div/span[contains(@id, 'newBuyBoxPrice')]";
    String findNumberOfFeedBacks = "//div[contains(@id, 'averageCustomerReviews_feature_div')]//span[contains(@id, 'acrCustomerReviewText')]";

    public BookDetail(String url, WebDriver driver){
        this.url = url;
        this.driver = driver;
        this.driver.navigate().to(url);
    }


    public Book getBookFromPage(){
        book.setName(getNameOfBook());
        book.setAuthor(getAuthorOfBook());
        book.setPrice(getPriceOfBook());
        book.setChekOnBestseller(getNumberOfFeedBacksOfBook());
        return book;
    }

    public String getNameOfBook(){
        return driver.findElement(By.xpath(findNameOfBook)).getText();
    }
    public String getAuthorOfBook(){
        return driver.findElement(By.xpath(findAuthorBook)).getText();
    }
    public String getPriceOfBook(){
        return driver.findElement(By.xpath(findPriceBook)).getText();
    }
    public String getNumberOfFeedBacksOfBook(){
        return (Integer.parseInt(driver.findElement(By.xpath(findNumberOfFeedBacks)).getText().replace(",", "").replace(" ratings", "")) > 400) ? "Bestseller" : "Not bestseller";
    }

    public Book getBook() {
        return book;
    }
}
