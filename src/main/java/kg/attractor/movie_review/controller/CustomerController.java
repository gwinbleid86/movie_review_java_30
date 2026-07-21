package kg.attractor.movie_review.controller;

import jakarta.validation.Valid;
import kg.attractor.movie_review.dto.CustomerDto;
import kg.attractor.movie_review.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("{email}")
    public CustomerDto findById(@PathVariable String email) {
        return customerService.findById(email);
    }

    @PostMapping
    public HttpStatus createCustomer(@Valid CustomerDto dto) {
        customerService.save(dto);
        return HttpStatus.OK;
    }
}
