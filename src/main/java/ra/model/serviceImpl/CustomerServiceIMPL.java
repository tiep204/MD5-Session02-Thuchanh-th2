package ra.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Customer;
import ra.model.repository.ICustomerRepository;
import ra.model.service.ICustomerService;

@Service
public class CustomerServiceIMPL implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return customerRepository.insertWithStoredProcedure(customer);
    }
}
