package SauceDemo

import geb.spock.GebSpec
import org.openqa.selenium.Dimension
import SauceDemo.pages.*


class BaseSpec extends GebSpec{

    def setup() {
    }

    def setBrowserSize(Dimension size){
        def dimensionChange = browserSize.width != size.width
        driver.manage().window().setSize(size)
        if(dimensionChange){sleep(1000)}
    }

    Dimension getBrowserSize(){
        driver.manage().window().getSize()
    }

    //This allows us to have our test jump to any page without having to go through a workflow..
    //Can add addition things like checking to see if a users is already logged in etc.
    def <T> T loadPage (Class<T> appPage = LoginPage)
    {
        browser.setBaseUrl(System.getProperty("server.base.url"))
        this.driver.manage().window().maximize()

        switch (appPage) {
            case LoginPage:
                try {
                    browser.to(LoginPage)
                }
                catch (AssertionError e)
                {
                   // If we wanted to do something with browser alerts we could create a method to work with them
                }
                at LoginPage
                break
            case ProductsPage:
                try {
                    browser.to(ProductsPage)
                }
                catch (AssertionError e)
                {
                    // If we wanted to do something with browser alerts we could create a method to work with them
                }
                at ProductsPage
                break
            case CartPage:
                try {
                    browser.to(CartPage)
                }
                catch (AssertionError e)
                {
                    // If we wanted to do something with browser alerts we could create a method to work with them
                }
                at CartPage
                break
            case CheckoutPage:
                try {
                    browser.to(CheckoutPage)
                }
                catch (AssertionError e)
                {
                    // If we wanted to do something with browser alerts we could create a method to work with them
                }
                at CheckoutPage
                break

        }
        return page as T
    }
}