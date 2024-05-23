package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.model.Pet;
@Mapper
public interface PetMapper {
	Pet findById(long id);
    List<Pet> findAll();
    long insert(@Param("name") Pet name);
    long update(@Param("name") Pet name);
    boolean delete(long id);

}
