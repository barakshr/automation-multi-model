package selenium_tests.herokuapp_experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class CanvasToImage extends BaseExperiment {
    @Test
    public void canvasToImage() throws IOException {
        getWebDriver().get("https://the-internet.herokuapp.com/challenging_dom");
        WebElement webElement = getWebDriver().findElement(By.id("canvas"));
        String js = "return arguments[0].toDataURL('image/png').substring(21);";
        Object obj = ((JavascriptExecutor) getWebDriver()).executeScript(js, webElement);
        byte[] x= Base64.getMimeDecoder().decode(obj.toString());
        File file= new File("/Users/barakshamir/Documents/file.png");
        FileOutputStream fo=new FileOutputStream(file);
        fo.write(x);
    }
}
