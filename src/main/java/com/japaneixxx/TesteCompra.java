package com.japaneixxx;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TesteCompra {

    @Test
    public void teste(){
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        navegador.get("https://www.saucedemo.com/");
        //Login
        navegador.findElement(By.id("user-name")).sendKeys("standard_user");
        navegador.findElement(By.id("password")).sendKeys("secret_sauce");
        navegador.findElement(By.id("login-button")).click();

        //Abrir Produto
        navegador.findElement(By.id("item_0_title_link")).click();
        //String name = navegador.findElement(By.className("inventory_details_name large_size")).getText();
        //Assertions.assertEquals("Sauce Labs Bike Light", name);
        //Adicionar ao Carrinho
        navegador.findElement(By.id("add-to-cart")).click();
        String quantity = navegador.findElement(By.className("shopping_cart_badge")).getText();
        Assertions.assertEquals("1", quantity);
        //Abrir Carrinho
        navegador.findElement(By.className("shopping_cart_link")).click();
        String item = navegador.findElement(By.className("inventory_item_name")).getText();
        Assertions.assertEquals("Sauce Labs Bike Light", item);

        //Comprar Carrinho
        navegador.findElement(By.id("checkout")).click();
        navegador.findElement(By.id("first-name")).sendKeys("Japa");
        navegador.findElement(By.id("last-name")).sendKeys("Cama");
        navegador.findElement(By.id("postal-code")).sendKeys("69420");
        navegador.findElement(By.id("continue")).click();
        navegador.findElement(By.id("finish")).click();



    }
}
