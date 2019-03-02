package SauceDemo

import SauceDemo.pages.CartPage
import SauceDemo.pages.LoginPage
import SauceDemo.pages.ProductsPage


class AddItemsToCartSpec extends BaseSpec{

    def "Add Items to cart and check cart contents"()
    {
        given:"A valid user name and password"
        def username = System.getProperty("webprofile.username")
        def password = System.getProperty("webprofile.password")
        def loginPage = loadPage(LoginPage)
        def item1 ="Sauce Labs Backpack"
        def item2 = "Sauce Labs Onesie"

        when:"User logs into website and adds two items to the shopping cart"
        loginPage.username = username
        loginPage.password = password
        loginPage.loginButton.click()
        def productPage = at ProductsPage
        def items = productPage.productList.productModule
        productPage.addItemtoBuy(item1,items)
        productPage.addItemtoBuy(item2,items)
        productPage.shoppingcart.click()
        def cartpage = at CartPage
        def cartitems = cartpage.cartList.cartModule
        then:"Those two items display in the shopping cart"
        cartpage.isIteminCart(item1,cartitems)
        cartpage.isIteminCart(item2,cartitems)
    }



}
