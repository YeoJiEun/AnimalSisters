package com.example.pet.controller.pet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pet.domain.Pet;
import com.example.pet.domain.User;
import com.example.pet.service.PetService;

@Controller
@RequestMapping("/view/pet/*")
public class PetController {

	@Autowired(required=true)
	private PetService petService;

	@ModelAttribute("petForm")
	public Pet formBacking(HttpSession session) {
		User user = (User)session.getAttribute("user");
		Pet pet = petService.getPetInfo(user.getM_num());
		return pet;
	}
	
	@RequestMapping(value="/pet_main", method=RequestMethod.GET)
	public String search(@ModelAttribute("Pet") Pet pet, Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		pet = petService.getPetInfo(user.getM_num());
		System.out.println("select: " + pet);
		
		if(pet == null)
			model.addAttribute("url", "pet_register");
		else
		{	
			model.addAttribute("petForm", pet);
			model.addAttribute("url", "pet_main");
		}
		
		return "user/mypage/mypage_main";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute("Pet") Pet pet, Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		pet.setM_num(user.getM_num());
		
		System.out.println("insert pet: " + pet.toString());
		
		if(petService.insertPet(pet) != 1)
			System.out.println("insert error");
		
		return "user/mypage/mypage_main";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		int result = petService.deletePet(user.getM_num());
		
		if(result != 1){
			System.out.println("delete error");
		}
		
		return "user/mypage/mypage_main";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("petForm") Pet pet, Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		pet.setM_num(user.getM_num());
		
		System.out.println("pet: " + pet.toString());
		System.out.println("model: " + model.toString());
		
		if(petService.updatePet(pet) != 1)
			System.out.println("update error");
		
		model.addAttribute("url", "pet_main");
		
		return "user/mypage/mypage_main";
	}
}
