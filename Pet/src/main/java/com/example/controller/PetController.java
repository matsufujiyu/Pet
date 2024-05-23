package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PetResponse;
import com.example.mapper.PetMapper;
import com.example.model.Pet;

@RestController
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private PetMapper petMapper;

	//登録されているPetリストを表示
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PetResponse> getPets() {
		List<PetResponse> petResponseList = new ArrayList<>();

		List<Pet> petList = petMapper.findAll();

		petList.forEach(pet -> {
			PetResponse petResponse = new PetResponse();
			BeanUtils.copyProperties(pet, petResponse);
			petResponseList.add(petResponse);
		});

		return petResponseList;
	}

	//登録されているPetリストを１件表示
	@GetMapping("/{id}")
	public PetResponse findById(@PathVariable long id) {
		// DBからidをキーにデータを取得
		Pet pet = petMapper.findById(id);

		// Responseにデータをコピーしてreturn
		PetResponse petResponse = new PetResponse();
		BeanUtils.copyProperties(pet, petResponse);
		return petResponse;
	}

	/*//登録されているPetリストを表示
	@GetMapping
	public List<Pet> getAllpet() {
		return petMapper.findAll();

	}

	//登録されているPetリストを１件表示
	@GetMapping("/{id}")
	public Pet getPet(@PathVariable("id") long id) {
		return petMapper.findById(id);

	}*/
}
