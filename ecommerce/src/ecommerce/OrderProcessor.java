package ecommerce;

public class OrderProcessor implements Runnable {
    private Order order;

    public OrderProcessor(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        processOrder();
    }

    private void processOrder() {
        System.out.println("Processing order for: " + order.getProduct().getName() + " Quantity: " + order.getQuantity());
        // Simulate processing time
        try {
            Thread.sleep(2000); // Simulate processing time of 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double totalPrice = order.getProduct().getPrice() * order.getQuantity();
        System.out.println("Order processed for: " + order.getProduct().getName() + ". Total price: $" + totalPrice);
    }
}
