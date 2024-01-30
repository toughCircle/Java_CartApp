package practice.cartApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Cart {
    HashMap<Product, Integer> products = new HashMap<>();
    public void importCSV(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("start reading CSV file");
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String key = values[0];
                String name = values[1];
                int price = Integer.parseInt(values[2]);
                Product product = new Product(key, name, price);
                this.addProduct(product, 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showItems() {
        for (Product product : products.keySet()) {
            System.out.printf("%s : %d\n", product.getName(), products.get(product));
        }
    }

    public  boolean doseExist(Product product) {
        return products.containsKey(product);
    }

    public void addProduct(Product product, int count) {
        if (this.doseExist(product)) {
            int productCount = products.get(product);
            productCount += count;
            products.put(product, productCount);
        }
        products.put(product, count);
    }

    public void removeProduct(Product product, int count) {
        if (this.doseExist(product)) {
            int productCount = products.get(product);
            productCount -= count;
            if (productCount <= 0) {
                products.remove(product);
            } else if (productCount > 0) {
                products.put(product, productCount);
            }
        } else {
            System.out.println("해당 상품이 존재하지 않습니다.");
        }
    }
}
