package kg.attractor.movie_review.service;

import kg.attractor.movie_review.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getCustomerList();

    CustomerDto findById(String email);

    void save(CustomerDto dto);
}
