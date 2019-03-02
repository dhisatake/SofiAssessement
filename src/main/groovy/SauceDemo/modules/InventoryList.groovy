package SauceDemo.modules

import geb.Module

class InventoryList extends Module{

    static content = {
        productModule(wait:true){$("div",class:"inventory_item").collect{it.module(new inventoryItem())}}
    }

}
