package SauceDemo.modules



class inventoryItem extends InventoryList{

    static content = {
        addtocartbutton{$("button",class:"add-to-cart-button")}
        productdesc{$("div",class:"inventory_item_desc")}
        productprice{$("div",class:"inventory_item_price")}
        productname{$("div",class:"inventory_item_name")}
        productimg{$("a",class:"inventory_item_img")}
    }
}
