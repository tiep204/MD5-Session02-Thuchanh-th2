package ra.model.repository.impl;

import ra.model.entity.Customer;
import ra.model.repository.ICustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public class CustomerRepositoryIMPL implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        return query.executeUpdate() == 0;
    }
}
