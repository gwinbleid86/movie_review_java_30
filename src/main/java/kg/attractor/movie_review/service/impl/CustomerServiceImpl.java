package kg.attractor.movie_review.service.impl;

import kg.attractor.movie_review.dao.CustomerDao;
import kg.attractor.movie_review.dto.CustomerDto;
import kg.attractor.movie_review.exception.CustomerNotFoundException;
import kg.attractor.movie_review.model.Customer;
import kg.attractor.movie_review.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    @Override
    public List<CustomerDto> getCustomerList() {
        List<Customer> customers = customerDao.findAll();

        return customers.stream()
                .map(e -> CustomerDto.builder()
                        .id(e.getId())
                        .name(e.getUsername())
                        .password(e.getPassword())
                        .build()
                )
                .toList();
    }

    @Override
    public CustomerDto findById(Integer id) {
        Customer customer = customerDao.findById(id)
                .orElseThrow(CustomerNotFoundException::new);

        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getUsername())
                .password(customer.getPassword())
                .build();
    }
}
