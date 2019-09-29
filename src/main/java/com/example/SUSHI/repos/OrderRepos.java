package com.example.SUSHI.repos;

import com.example.SUSHI.domain.OrderSushi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OrderRepos extends CrudRepository<OrderSushi,Integer> {

    List<OrderSushi> findById(Long longId);
    List<OrderSushi> findAll();


}
