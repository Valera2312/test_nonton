package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsImplTest {

    static ProductsImpl products = new ProductsImpl();

    @BeforeAll
    static void addProducts() {
        products.addProduct(new Product("1", "Монитор"));
        products.addProduct(new Product("2", "Мышь"));
        products.addProduct(new Product("3", "Клавиатура"));
        products.addProduct(new Product("4", "Камера"));
        products.addProduct(new Product("5", "Клавиатура"));
    }

    @Test
    void addProduct() {
        assertTrue(products.addProduct(new Product("6", "Видеокарта")));
        assertFalse(products.addProduct(new Product("6", "Видеокарта")));
    }

    @Test
    void deleteProduct() {
        assertTrue(products.deleteProduct(new Product("4", "Камера")));
        assertFalse(products.deleteProduct(new Product("4", "Камера")));
    }

    @Test
    void getName() {
        assertEquals(products.getName("1"), "Монитор");
        assertEquals(products.getName("0"), "");
    }

    @Test
    void findByName() {
        assertEquals(products.findByName("Клавиатура"), List.of("3","5"));
        assertEquals(products.findByName("Процессор"), Collections.EMPTY_LIST);
    }
}