package com.hpkarugendo.projects.dbimagetest;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public List<UserModel> getAll(){
		return uRepo.findAll();
	}
	
	public UserModel saveUser(UserModel user) {
		UserModel ans = null;
		try {
			ans = uRepo.save(user);
			System.out.println("USER SAVED SUCCESSFULLY!");
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, "ERROR SAVING USER WITH!!!: " + e);
		}
		return ans;
	}
	
	public UserModel findUser(int id) {
		Optional<UserModel> ans = uRepo.findById(id);
		if(ans.isPresent()) {
			return ans.get();
		} else {
			return null;
		}
	}
	
	public void deleteUser(int id) {
		Optional<UserModel> ans = uRepo.findById(id);
		if(ans.isPresent()) {
			try {
				uRepo.delete(ans.get());
				Logger.getGlobal().log(Level.WARNING, "USER HAS BEEN DELETED!!");
			} catch (Exception e) {
				Logger.getGlobal().log(Level.SEVERE, "ERROR DELETING USER!!!: " + e);
			}
		}
	}

}
