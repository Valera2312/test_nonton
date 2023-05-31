package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Product {
   private String id;
   private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class ProductsImpl {

    private Map<String, Product> products;

    public ProductsImpl() {
        this.products = new HashMap<>();
    }

    public boolean addProduct(Product product) {
        if (products.containsKey(product.getId())) {
            return false;
        }
        products.put(product.getId(), product);
        return true;
    }

    public boolean deleteProduct(Product product) {
        if (!products.containsKey(product.getId())) {
            return false;
        }
        products.remove(product.getId());
        return true;
    }

    public String getName(String id) {
        Product product = products.get(id);
        if (product != null) {
            return product.getName();
        }
        else {
            return "";
        }
    }

    public List<String> findByName(String name) {
        return products.entrySet().stream()
                .filter(entry->entry.getValue().getName().equals(name))
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
}

