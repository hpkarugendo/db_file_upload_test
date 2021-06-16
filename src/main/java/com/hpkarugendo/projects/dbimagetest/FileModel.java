package com.hpkarugendo.projects.dbimagetest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FileModel {
	@Id
	@GeneratedValue
	private int id;
	@Lob
	private byte[] file;
	public FileModel() {
		super();
	}
	public FileModel(byte[] file) {
		super();
		this.file = file;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}

}
