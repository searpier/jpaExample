package com.example.jpaexample.controller;

import com.example.jpaexample.dto.ExampleReqDTO;
import com.example.jpaexample.dto.ExampleResDTO;
import com.example.jpaexample.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {

    @Autowired
    ExampleService es;

    @GetMapping("/insert")
    public ExampleResDTO mergeExample(){
        ExampleReqDTO dto=new ExampleReqDTO(1L,"fish",1500);
        return es.merge(dto);
    }

    @GetMapping("/selectAll")
    public List<ExampleResDTO> selectAll(){
        return es.selectAll();
    }

    @GetMapping("/selectOne")
    public ExampleResDTO selectOne(){
        return es.selectOne(new ExampleReqDTO(7L,"fish",1500));
    }

    @GetMapping("/deleteOne")
    public void deleteOne(){
        es.deleteOne(new ExampleReqDTO(7L,"fish",1500));
    }
    @GetMapping("/deleteAll")
    public void deleteAll(){
        es.deleteAll();
    }
    @GetMapping("/selectByName")
    public List<ExampleResDTO> selectByName(){
        ExampleReqDTO dto=new ExampleReqDTO(1L,"fish3",1500);
        return es.selectByName(dto);
    }
    @GetMapping("/selectByNameStartingWith")
    public List<ExampleResDTO> selectByNameStartingWith(){
        ExampleReqDTO dto=new ExampleReqDTO(1L,"fish",1500);
        return es.selectByNameStartingWith(dto);
    }
    @GetMapping("/findByPriceLessThan")
    public List<ExampleResDTO> findByPriceLessThan(){
        ExampleReqDTO dto=new ExampleReqDTO(1L,"fish",3000);
        return es.findByPriceLessThan(dto);
    }
    @GetMapping("/findByNameAndPrice")
    public List<ExampleResDTO> findByNameAndPrice(){
        ExampleReqDTO dto=new ExampleReqDTO(1L,"fish4",4500);
        return es.findByNameAndPrice(dto);
    }


}
