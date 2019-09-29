package com.example.SUSHI.repos;

import com.example.SUSHI.domain.NewSushi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NewSushiRepos extends CrudRepository<NewSushi, Integer> {

    List<NewSushi> findByName(String name);


}

