interface CustomerRepository {
    String findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        if (id == 1) return "John Doe";
        else if (id == 2) return "Jane Smith";
        else return "Customer not found";
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomer(int id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println("Customer: " + customer);
    }
}

public class depin {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        service.displayCustomer(1);
        service.displayCustomer(2);
        service.displayCustomer(3);
    }
}
