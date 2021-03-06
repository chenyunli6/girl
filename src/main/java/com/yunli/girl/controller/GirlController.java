package com.yunli.girl.controller;

import com.yunli.girl.domain.Girl;
import com.yunli.girl.domain.Result;
import com.yunli.girl.repository.GirlRepository;
import com.yunli.girl.service.GirlService;
import com.yunli.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        logger.info("girlList");
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping(value = "/girls/{id}")
    public Girl girlFind(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age) {
        return girlRepository.findGirlByAge(age);
    }

    @PatchMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("age") Integer age) {
        Girl girl = girlRepository.findOne(id);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        Girl girl = girlRepository.findOne(id);
        girlRepository.delete(girl);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public Girl getAge(@PathVariable("id") Integer id) throws Exception {
        return girlService.getAge(id);
    }
}
