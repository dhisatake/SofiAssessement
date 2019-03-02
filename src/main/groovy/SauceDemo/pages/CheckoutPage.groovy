package SauceDemo.pages


class CheckoutPage extends SwagLabPage {
    static at = { waitFor { js."document.readyState" == "complete" } }

    static content = {

        //Other content needed to complete page but not used in assignment
        cancel(to: [ProductsPage]) { $ "a", class: "cart_cancel_link" }
    }
}