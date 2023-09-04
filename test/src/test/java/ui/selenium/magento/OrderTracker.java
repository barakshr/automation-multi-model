package ui.selenium.magento;


import com.team.selenium.properties.Settings;
import com.team.selenium_pages.pages.magento.HomePage;
import com.team.selenium_pages.pages.magento.PaymentPage;
import com.team.selenium_pages.pages.magento.enums.CustomerDetailsPageTextField;
import com.team.selenium_pages.pages.magento.enums.PurchasingCategory;
import ui.selenium.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;

public class OrderTracker extends BaseTest {

    @Test
    @Parameters({"emailAddress", "firstName", "lastName", "company", "city", "streetFirstFirstLine", "zipCode", "phoneNumber","country"})
    public void writeOrderIdToFile(String email, String firstName, String lastName, String company, String city, String streetFirstFirstLine, String zipCode, String phoneNumber,String country) throws Exception {
        HomePage homePage = new HomePage();
        String orderId = homePage
                .hoverOnCategory(PurchasingCategory.Gear)
                .enterToCategory(PurchasingCategory.Bags)
                .addItemToCart(0)
                .goToCustomerDetailsPage()
                .waitForPageToLoad(Duration.ofSeconds(7))
                .enterEmailAddress(email)
                .enterToTextBox(CustomerDetailsPageTextField.FirstName, firstName)
                .enterToTextBox(CustomerDetailsPageTextField.LastName, lastName)
                .enterToTextBox(CustomerDetailsPageTextField.Company, company)
                .enterToTextBox(CustomerDetailsPageTextField.City, city)
                .enterToTextBox(CustomerDetailsPageTextField.StreetFirstFirstLine, streetFirstFirstLine)
                .enterToTextBox(CustomerDetailsPageTextField.ZipCode, zipCode)
                .enterToTextBox(CustomerDetailsPageTextField.PhoneNumber, phoneNumber)
                .selectCountry(country)
                .setRateShipment()
                .clickOnNext()
                .goToPage(PaymentPage.class)
                .clickOnPlaceOrder()
                .getOrderId();
        writeToTxtFile("orderId:" + orderId);
    }


    private void writeToTxtFile(String orderId) throws IOException {
        FileWriter fileWriter = new FileWriter(Settings.DataFilePath);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(orderId);
        printWriter.close();
    }

}
