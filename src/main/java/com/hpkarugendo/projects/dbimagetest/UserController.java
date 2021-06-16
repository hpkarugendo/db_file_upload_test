package com.hpkarugendo.projects.dbimagetest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private FileService fService;
	
	@GetMapping({"/", "/form"})
	public String form(Model m) {
		m.addAttribute("userObject", new UserModel());
		return "form";
	}
	
	@GetMapping("/admin")
	public String admin(Model m) {
		m.addAttribute("users", uService.getAll());
		return "admin";
	}
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute("userObject") UserModel user, 
			@RequestParam("hFile") MultipartFile hFile,
			@RequestParam("fbFile") MultipartFile fbFile,
			@RequestParam("tFile") MultipartFile tFile
			, Model m) throws IOException {
		
		if(!hFile.isEmpty() && hFile.getSize() > 5) {
			user.setHotelRecId(fService.saveFile(new FileModel(hFile.getBytes())));
		}
		if(!fbFile.isEmpty() && fbFile.getSize() > 5) {
			user.setFoodBeverageRecId(fService.saveFile(new FileModel(fbFile.getBytes())));
		}
		if(!tFile.isEmpty() && tFile.getSize() > 5) {
			user.setTravelRecId(fService.saveFile(new FileModel(tFile.getBytes())));
		}
		
		UserModel saved = uService.saveUser(user);
		
		if( saved == null) {
			m.addAttribute("mNo", "User Could Not Be Saved!");
			m.addAttribute("userObject", user);
			return "form";
		} else {
			m.addAttribute("mOk", "User Saved Successfully!");
			m.addAttribute("userObject", saved);
			return "result";
		}
	}
	
	@GetMapping("/image/{id}")
	public void showImage(@PathVariable("id") int id, HttpServletResponse res) {
		res.setContentType("image/jpeg");
		try {
			InputStream is = new ByteArrayInputStream(fService.findFile(id).getFile());
			IOUtils.copy(is, res.getOutputStream());
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, "ERROR READING IN FILE!!!: " + e);
		}
	}
}
