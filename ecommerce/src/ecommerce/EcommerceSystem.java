package ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EcommerceSystem {
	 public static void main(String[] args) {
	        Product product1 = new Product("Laptop", 1000);
	        Product product2 = new Product("Phone", 500);
	        Product product3 = new Product("Tablet", 300);

	        List<Order> orders = new ArrayList<>();
	        orders.add(new Order(product1, 2));
	        orders.add(new Order(product2, 1));
	        orders.add(new Order(product3, 3));

	        // Create a thread pool with fixed number of threads
	        ExecutorService executor = Executors.newFixedThreadPool(3);

	        // Process each order concurrently using multiple threads
	        for (Order order : orders) {
	            executor.execute(new OrderProcessor(order));
	        }

	        // Shutdown the executor service after all tasks are completed
	        executor.shutdown();
	 }

}
