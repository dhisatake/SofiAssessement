package SauceDemo.pages
import geb.Page

class LoginPage extends Page{

    static at = {waitFor {js."document.readyState"== "complete"}}

    static content = {

        username{$"input",id:"user-name"}
        password{$"input",id:"password"}
        loginButton(to:[ProductsPage]){$("input",class:"login-button")}
    }

}
