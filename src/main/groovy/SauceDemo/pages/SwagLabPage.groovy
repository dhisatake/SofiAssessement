package SauceDemo.pages

import geb.Page

class SwagLabPage extends Page{
    static at = {waitFor {js."document.readyState"== "complete"}}

    static content = {

        shoppingcart(to:[CartPage]){$"div",id:"shopping_cart_container"}
        menubutton{$"button",class:"bm-burger-button"}
    }

}
