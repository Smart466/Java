package com.example.directorypkg.controller;



import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.directorypkg.repository.FileRepository;
//import com.example.directorypkg.repository.FileRepository;
import com.example.directorypkg.service.FileService;

@RestController
@RequestMapping("/files")
public class FileController {

	@Autowired
	private FileService fileService;
	@Autowired
	private FileRepository fileRepository;
	
	@GetMapping
	public String saveFileObject() {
		
		fileService.saveFileInfo();
	
		
		return "File object saved successfully";
	}
	@GetMapping({ "/"})
	public ModelAndView folderdetails() {
		ModelAndView model = new ModelAndView("list-folders");


		model.addObject("folderDetails", fileRepository.findAll());

		return model;
	}
	
}

