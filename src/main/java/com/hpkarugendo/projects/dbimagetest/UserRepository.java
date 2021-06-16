package com.hpkarugendo.projects.dbimagetest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
	List<UserModel> findAll();
}
