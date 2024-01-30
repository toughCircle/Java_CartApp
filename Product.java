package practice.cartApp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Product {
    private String key;
    private String name;
    private int price;

    public Product(String key, String name, int price) {
        this.key = key;
        this.name = name;
        this.price = price;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;

        return Objects.equals(name, product.name) && Objects.equals(key, product.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name);
    }
}
