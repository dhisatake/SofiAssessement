package SauceDemo.modules

import geb.Module

class CartList extends Module {

    static content = {
        cartModule(wait: true) { $("div", class: "cart_item").collect{it.module(new cartItem())}}
    }
}