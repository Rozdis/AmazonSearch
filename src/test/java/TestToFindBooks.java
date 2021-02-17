import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestToFindBooks {
    public WebDriver webDriver;
    private List<Book> books = new ArrayList<>();

    @BeforeTest
    public void openAndFindPage(){
     System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.navigate().to("https://www.amazon.com/");


        SearchPage searchPage = new SearchPage(webDriver);
        searchPage.useFilterBooks();
        searchPage.setInputSearch("java");
    }
    @Test
    public void test(){
        String expectedTitle = "Amazon.com : java";
        Assert.assertEquals(webDriver.getTitle(), expectedTitle);

        BookPage bookPage = new BookPage(webDriver);
        bookPage.saveValuesToList(books);

            Assert.assertTrue(bookPage.chekBookInList("Head First Java, 2nd Edition", books));
    }

    @AfterTest
    public void terminateBrowser(){
        webDriver.close();
    }

}
