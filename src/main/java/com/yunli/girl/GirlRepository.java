package com.yunli.girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {
    List<Girl> findGirlByAge(Integer age);
}
