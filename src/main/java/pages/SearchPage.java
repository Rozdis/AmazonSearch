package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class SearchPage {
    By filterBook = By.xpath("//*[@id=\"searchDropdownBox\"]/option[6]");
    By  inputSearch = By.xpath("//*[@id=\"twotabsearchtextbox\"]");

    private final WebDriver webDriver;


    public SearchPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void useFilterBooks() throws InterruptedException {
        TimeUnit.SECONDS.sleep(30);
        webDriver.findElement(filterBook).click();
    }

    public void setInputSearch(String query){
        webDriver.findElement(inputSearch).sendKeys(query);
        webDriver.findElement(inputSearch).sendKeys(Keys.ENTER);

    }

}
