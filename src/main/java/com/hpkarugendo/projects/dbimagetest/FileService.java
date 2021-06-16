package com.hpkarugendo.projects.dbimagetest;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	@Autowired
	private FileRepository fRepo;
	
	public List<FileModel> getAll(){
		return fRepo.findAll();
	}
	
	public FileModel findFile(int id) {
		Optional<FileModel> ans = fRepo.findById(id);
		if(ans.isPresent()) {
			return ans.get();
		} else {
			return null;
		}
	}
	
	public int saveFile(FileModel file) {
		int ans = 0;
		
		try {
			FileModel saved = fRepo.save(file);
			ans = saved.getId();
			System.out.println("FILE SAVED SUCCESSFULLY!");
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, "ERROR SAVING FILE!!: " + e);
		}
		
		return ans;
	}
	
	public void deleteFile(int id) {
		Optional<FileModel> toDelete = fRepo.findById(id);
		if(toDelete.isPresent()) {
			try {
				fRepo.delete(toDelete.get());
				System.out.println("FILE DELETED SUCCESSFULLY!");
			} catch (Exception e) {
				Logger.getGlobal().log(Level.WARNING, "ERROR DELETING FILE!!: " + e);
			}
		}
	}

}
