package com.example.SUSHI.repos;

import com.example.SUSHI.domain.SushiSet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SushiSetRepos extends CrudRepository<SushiSet,Integer> {

    List<SushiSet> findByName(String name);

}
