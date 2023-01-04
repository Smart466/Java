package com.example.directorypkg.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.directorypkg.entity.FileData;


@Repository
public interface FileRepository extends JpaRepository<FileData, Integer> {
	List<FileData> findAll();
	
}


