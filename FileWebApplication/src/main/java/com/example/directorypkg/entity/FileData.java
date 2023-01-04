package com.example.directorypkg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="file_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FileData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="folder_Name")
	private String folder_Name;
	
	@Column(name="no_Of_Files")
	private long no_Of_Files;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFolder_Name() {
		return folder_Name;
	}

	public void setFolder_Name(String folder_Name) {
		this.folder_Name = folder_Name;
	}

	public long getNo_Of_Files() {
		return no_Of_Files;
	}

	public void setNo_Of_Files(long no_Of_Files) {
		this.no_Of_Files = no_Of_Files;
	}
	
	
	

}



