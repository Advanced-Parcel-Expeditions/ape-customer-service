package si.ape.customer.services.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


import si.ape.customer.lib.Customer;
import si.ape.customer.lib.Parcel;
import si.ape.customer.models.converters.CustomerConverter;
import si.ape.customer.models.entities.CustomerEntity;
import si.ape.customer.models.entities.ParcelEntity;
import si.ape.customer.models.converters.ParcelConverter;


@RequestScoped
public class CustomerBean {

    private Logger log = Logger.getLogger(CustomerBean.class.getName());

    @Inject
    private EntityManager em;

    public List<Customer> findCustomers(String searchString) {
        TypedQuery<CustomerEntity> query = em.createNamedQuery("CustomerEntity.getBySearchString", CustomerEntity.class);
        query.setParameter("searchString", "%" + searchString + "%");
        List<CustomerEntity> customerEntities = query.getResultList();
        List<Customer> customers = customerEntities.stream().map(CustomerConverter::toDto).toList();
        return customers;
    }

    private void beginTx() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    private void commitTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }

}
