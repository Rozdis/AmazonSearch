import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BookPage {
    By findListOfBooks = By.cssSelector("div.s-asin");
    By findNameOfBook = By.cssSelector("span.a-text-normal");
    By findAuthorBook = By.cssSelector("a.a-size-base");
    By findPriceBook = By.cssSelector("span:nth-child(2) > span.a-price-whole");
    By findNumberOfFeedBacks = By.cssSelector("a > span.a-size-base");

    private final WebDriver webDriver;


    private List<WebElement> listOfBooks;

    public BookPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void showResult(){
     //   listOfBooks = webDriver.findElements(findListOfBooks);
       // System.out.println(listOfBooks.size());
      // for (WebElement element : listOfBooks) {
          // System.out.println("-------------------------");
          // System.out.println(element.findElement(findNameOfBook).getText());
          // System.out.println(element.findElement(findAuthorBook).getText());
          // System.out.println(element.findElement(findPriceBook).getText());
           //System.out.println((Integer.parseInt(element.findElement(findNumberOfFeedBacks).getText().replace(",", "")) > 400)) ? "Bestseller" : "Not bestseller"));
        //}

    }

    public void saveValuesToList(List<Book> booksList){
        listOfBooks = webDriver.findElements(findListOfBooks);
        for (WebElement element : listOfBooks){
            booksList.add(new Book(element.findElement(findNameOfBook).getText(),
                    element.findElement(findAuthorBook).getText(),
                    element.findElement(findPriceBook).getText(),
                    (Integer.parseInt(element.findElement(findNumberOfFeedBacks).getText().replace(",", "")) > 400) ? "Bestseller" : "Not bestseller"));

        }
        System.out.println(booksList.size());
        for (Book book : booksList) {
            System.out.println(book.toString());
        }
    }

    public boolean chekBookInList(String nameOfBook, List<Book> bookList){
        for (Book book : bookList){
            if (book.getName().equals(nameOfBook))
                return true;
        }
        return false;
    }


    public WebDriver getWebDriver() {
        return webDriver;
    }
    public List<WebElement> getListOfBooks() {
        return listOfBooks;
    }
}
