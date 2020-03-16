package com.springboot.repos;

import com.springboot.models.ConformationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConformationTokenRepos extends JpaRepository<ConformationToken,String> {

    ConformationToken findByConformationToken(String conformationToken);
}
