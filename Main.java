package practice.cartApp;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Product> productSet = new HashSet<>();

        Product p1 = new Product("A", "바나나", 6000);
        Product p2 = new Product("B", "복숭아", 8000);
        Product p3 = new Product("C", "체리", 10000);
        Product p4 = new Product("B", "복숭아", 6000);
        Product p5 = new Product("D", "딸기", 11000);

        productSet.add(p1);
        productSet.add(p2);
        productSet.add(p3);
        productSet.add(p4);
        productSet.add(p5);

        System.out.println("고유한 상품 목록 : ");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        Cart myCart = new Cart();

        myCart.addProduct(p1, 3);
        myCart.addProduct(p2, 1);
        myCart.addProduct(p3, 1);
        myCart.addProduct(p5, 2);

        myCart.removeProduct(p1, 1);
        myCart.removeProduct(p3, 4);
        myCart.removeProduct(p3, 1);

        myCart.showItems();

        Cart cart = new Cart();

        String csvFilePath = "src/practice/cartApp/products.csv";

        cart.importCSV(csvFilePath);

        cart.showItems();

    }
}
