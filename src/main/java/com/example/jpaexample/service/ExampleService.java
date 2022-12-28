package com.example.jpaexample.service;

import com.example.jpaexample.dto.ExampleReqDTO;
import com.example.jpaexample.dto.ExampleResDTO;
import com.example.jpaexample.entity.Example;
import com.example.jpaexample.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExampleService {

    @Autowired
    ExampleRepository repo;

    public ExampleResDTO merge(ExampleReqDTO req){
        Example ex=req.toEntity();
        ex=repo.save(ex);
        return new ExampleResDTO(ex.getName());
    }

    public List<ExampleResDTO> selectAll(){

        List<Example> result=repo.findAll();

        List<ExampleResDTO> resList = result.stream()
                .map(ex->new ExampleResDTO(ex.getName()))
                .collect(Collectors.toList());

        return resList;
    }

    public ExampleResDTO selectOne(ExampleReqDTO req){
        Example res=repo.findById(req.getId()).orElse(null);
        return new ExampleResDTO(res.getName());
    }

    public void deleteOne(ExampleReqDTO req){
        repo.deleteById(req.getId());
    }

    public void deleteAll(){
        repo.deleteAll();
    }

    public List<ExampleResDTO> selectByName(ExampleReqDTO dto){

        List<Example> result=repo.findByName(dto.getName());

        List<ExampleResDTO> resList = result.stream()
                .map(ex->new ExampleResDTO(ex.getName()))
                .collect(Collectors.toList());

        return resList;
    }
    public List<ExampleResDTO> selectByNameStartingWith(ExampleReqDTO dto){

        List<Example> result=repo.findByNameStartingWith(dto.getName());

        List<ExampleResDTO> resList = result.stream()
                .map(ex->new ExampleResDTO(ex.getName()))
                .collect(Collectors.toList());

        return resList;
    }

    public List<ExampleResDTO> findByPriceLessThan(ExampleReqDTO dto){

        List<Example> result=repo.findByPriceLessThan(dto.getPrice());

        List<ExampleResDTO> resList = result.stream()
                .map(ex->new ExampleResDTO(ex.getName()))
                .collect(Collectors.toList());

        return resList;
    }


    public List<ExampleResDTO> findByNameAndPrice(ExampleReqDTO dto){

        List<Example> result=repo.findByNameAndPrice(dto.getName(),dto.getPrice());

        List<ExampleResDTO> resList = result.stream()
                .map(ex->new ExampleResDTO(ex.getName()))
                .collect(Collectors.toList());

        return resList;
    }

}
