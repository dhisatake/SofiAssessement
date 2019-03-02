package SauceDemo.modules

import geb.Module

class cartItem extends Module {
    static content = {
        addtocartbutton { $("button", class: "remove-from-cart-button") }
        itemname { $("div", class: "inventory_item_name") }
        itemprice { $("div", class: "inventory_item_price") }
        itemdesc { $("div", class: "inventory_item_desc") }
        productimg { $("div", class: "cart_quantity") }
    }
}