
interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("PayPal processed payment of $" + amount);
    }
}

class StripeGateway {
    public void makeStripePayment(double amount) {
        System.out.println("Stripe processed payment of $" + amount);
    }
}

class RazorpayGateway {
    public void doTransaction(double amount) {
        System.out.println("Razorpay processed payment of $" + amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.makeStripePayment(amount);
    }
}

class RazorpayAdapter implements PaymentProcessor {
    private RazorpayGateway razorpay;

    public RazorpayAdapter(RazorpayGateway razorpay) {
        this.razorpay = razorpay;
    }

    public void processPayment(double amount) {
        razorpay.doTransaction(amount);
    }
}

public class processpayment {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        PaymentProcessor razorpayProcessor = new RazorpayAdapter(new RazorpayGateway());

        paypalProcessor.processPayment(100.00);
        stripeProcessor.processPayment(250.50);
        razorpayProcessor.processPayment(499.99);
    }
}
