import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    By filterBook = By.xpath("//*[@id=\"searchDropdownBox\"]/option[6]");
    By  inputSearch = By.xpath("//*[@id=\"twotabsearchtextbox\"]");

    private final WebDriver webDriver;


    public SearchPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void useFilterBooks(){
        webDriver.findElement(filterBook).click();
    }

    public void setInputSearch(String query){
        webDriver.findElement(inputSearch).sendKeys(query);
        webDriver.findElement(inputSearch).sendKeys(Keys.ENTER);

    }

}
