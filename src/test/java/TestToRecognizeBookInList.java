import elements.Book;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import pages.ResultListOfBooks;
import pages.BookDetail;
import pages.SearchPage;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestToRecognizeBookInList {

    public WebDriver webDriver;
    private List<Book> books = new ArrayList<>();

    @BeforeTest
    public void openAndFindPage(){
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_linux");
     ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");

	DesiredCapabilities cap = DesiredCapabilities.chrome();
	cap.setBrowserName("chrome");
        webDriver = new ChromeDriver(options);
        SearchPage searchPage = new SearchPage(webDriver);
        webDriver.navigate().to("https://www.amazon.com/");

        searchPage.useFilterBooks();
        searchPage.setInputSearch("java");
    }
    @Test
    public void test(){
        ResultListOfBooks bookPage = new ResultListOfBooks(webDriver);
        bookPage.satValuesToList(books);
        Book book = new BookDetail("https://www.amazon.com/Effective-Java-Joshua-Bloch/dp/0134685997/ref=sr_1_1?dchild=1&keywords=java&qid=1613558034&s=books&sr=1-1", webDriver).getBookFromPage();

        Assert.assertTrue(books.contains(book));
    }

    @AfterTest
    public void terminateBrowser(){
        webDriver.close();
    }

}
