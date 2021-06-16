package com.hpkarugendo.projects.dbimagetest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends CrudRepository<FileModel, Integer> {
	List<FileModel> findAll();
}
