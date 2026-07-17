package kg.attractor.movie_review.controller;

import kg.attractor.movie_review.dto.CustomerDto;
import kg.attractor.movie_review.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getList() {
        return customerService.getCustomerList();
    }

    @GetMapping("{id}")
    public CustomerDto findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }
}
