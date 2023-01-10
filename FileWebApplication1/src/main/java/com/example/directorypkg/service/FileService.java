package com.example.directorypkg.service;



import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.directorypkg.entity.FileData;
import com.example.directorypkg.repository.FileRepository;


@Service
public class FileService {

	
	private static List<String> fileNames;
	
	private static FileRepository fileRepository;
	
	
	@Autowired
	public FileService(FileRepository fileRepository) {
		this.fileRepository=fileRepository;
		
	}
	
	static void countNoOfFilesInDirectory(String pathLocation) {
		
		fileNames = new ArrayList<>();
	
		FileData fileInfo = new FileData();
		 try {
			  DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(pathLocation));
		      for (Path path : directoryStream) {
		    	  if(Files.isDirectory(path)) {
		    		
		    		  fileInfo.setFolder_Name(path.toString());
		    		  System.out.println(path.toString());
		    		  countNoOfFilesInDirectory(path.toString());
		    	  }
		    	  else if(Files.isRegularFile(path)) {
		    		  fileInfo.setFolder_Name(path.toString());
		    		  System.out.println(path.toString());
		    		  
		    		  fileNames.add(path.toString());
		    	  }
		  
		    	  fileInfo.setNo_Of_Files(fileNames.size());
			      fileRepository.save(fileInfo);
				
			     // fileInfo=null;

//		         fileNames=null;
//		         folders=null;
		      }

		        
	    } 
		catch (IOException ex) {
	    }
	}
	
	public void saveFileInfo() {
		
		countNoOfFilesInDirectory("E:\\Siva");
	 
	}
	

}
