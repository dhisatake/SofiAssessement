package SauceDemo.pages

import SauceDemo.modules.CartList


class CartPage extends SwagLabPage {
    static at = { waitFor { js."document.readyState" == "complete" } }

    static content = {

        cartList{$("div",class:"cart_list").module(new CartList())}
        continueshopping(to: [ProductsPage]) { $ "a", class: "cart_cancel_link" }
        checkoutbutton(to: [CheckoutPage]) { $ "a", class: "cart_checkout_link" }
    }

    def isIteminCart(String itemName, def cartmod){
        def result = false;
        for (int x = 0; x < cartmod.size();x++)
        {
            if (itemName == cartmod.get(x).itemname.text())
            {
                result = true
            }
        }
        return result
    }
}