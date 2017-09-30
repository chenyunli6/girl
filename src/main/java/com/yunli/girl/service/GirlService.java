package com.yunli.girl.service;

import com.yunli.girl.domain.Girl;
import com.yunli.girl.enums.ResultEnum;
import com.yunli.girl.exception.GirlException;
import com.yunli.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    // 加事务注解，一条插入操作失败则全部插入操作失败
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("B");
        girlA.setAge(19);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(20);
        girlRepository.save(girlB);
    }

    public Girl getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        return girl;
    }
}
