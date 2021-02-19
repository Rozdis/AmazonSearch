package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import elements.Book;



import java.util.List;

public class ResultListOfBooks {
    String NameBook = "//div[contains(@class, 's-result-list')]/div[contains(@class, 's-result-item') and contains(@data-component-type, 's-search-result')][%s]//h2/a/span";
    String AuthorBook = "//div[contains(@class, 's-result-list')]/div[contains(@class, 's-result-item') and contains(@data-component-type, 's-search-result')][%s]//div[contains(@class, 'sg-row')]/div/div/div/div[contains(@class, 'a-row a-size-base a-color-secondary')]/span[contains(@class, 'a-size-base')] | //div[contains(@class, 's-result-list')]/div[contains(@class, 's-result-item') and contains(@data-component-type, 's-search-result')][%s]//div[contains(@class, 'sg-row')]/div/div/div/div[contains(@class, 'a-row a-size-base a-color-secondary')]/a[contains(@class, 'a-size-base a-link-normal')]";
    String PriceBook = "//div[contains(@class, 's-result-list')]/div[contains(@class, 's-result-item') and contains(@data-component-type, 's-search-result')][%s]//div[contains(@class, 'a-section a-spacing-none a-spacing-top-small')]//a/span//span[contains(@class, 'a-price-whole')] | //div[contains(@class, 's-result-list')]/div[contains(@class, 's-result-item') and contains(@data-component-type, 's-search-result')][%s]//div[contains(@class, 'a-section a-spacing-none a-spacing-top-mini')]//a/span//span[contains(@class, 'a-price-whole')]";
    String NumberFeedBacks = "//div[contains(@class, 's-result-list')]/div[contains(@class, 's-result-item') and contains(@data-component-type, 's-search-result')][%s]//div[contains(@class, 'sg-row')]/div/div/div/div/span/a/span";

    private final WebDriver webDriver;


    public ResultListOfBooks(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void satValuesToList(List<Book> booksList){

        for (int i = 1; i < 17; i++) {
            booksList.add(new Book(getNameByIndex(i),
                    getAuthorByIndex(i), getPriceByIndex(i),
                    (Integer.parseInt(getNumberOfFeedBacksByIndex(i).replace(",", "")) > 400) ? "Bestseller" : "Not bestseller"));
           // System.out.println(booksList.get(i - 1));
        }
    }


    public String getNameByIndex(int index){
        return webDriver.findElement(By.xpath(String.format(NameBook, index))).getText();
    }
    public String getAuthorByIndex(int index) {
        return webDriver.findElements(By.xpath(String.format(AuthorBook, index, index))).get(1).getText();
    }
    public String getPriceByIndex(int index) {
        return webDriver.findElement(By.xpath(String.format(PriceBook, index, index))).getText();
    }
    public String getNumberOfFeedBacksByIndex(int index) {
        return webDriver.findElement(By.xpath(String.format(NumberFeedBacks, index))).getText();
    }
    }
