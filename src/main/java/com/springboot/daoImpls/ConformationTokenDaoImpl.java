//package com.springboot.daoImpls;
//
//import com.springboot.daos.ConformationTokenDao;
//import com.springboot.dtos.ConformationTokenDto;
//import com.springboot.models.ConformationToken;
//import com.springboot.repos.ConformationTokenRepos;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//public class ConformationTokenDaoImpl implements ConformationTokenDao {
//    @Autowired
//    private ConformationTokenRepos conformationTokenRepos;
//
//    @Override
//    @Transactional
//    public void conformation(ConformationTokenDto conformationTokenDto) {
//        ConformationToken conformationToken = new ConformationToken();
//        conformationTokenRepos.save(conformationToken);
//
//    }
//}
