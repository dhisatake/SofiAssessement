package SauceDemo.pages

import SauceDemo.modules.InventoryList


class ProductsPage extends SwagLabPage{
    static at = {waitFor {js."document.readyState"== "complete"}}

    static content = {

        productList{$("div",class:"inventory_list").module(new InventoryList())}
        productsort{$"select",class:"product_sort_container"}
    }
    def addItemtoBuy(String itemName, def prodmod){
        for (int x = 0; x < prodmod.size();x++)
        {
            if (itemName == prodmod.get(x).productname.text())
            {
                prodmod.get(x).addtocartbutton.click()
            }
        }
    }
}
