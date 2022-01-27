package com.th.Repo;

import com.th.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepo extends JpaRepository<User,String>{

}
