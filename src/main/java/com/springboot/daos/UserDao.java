package com.springboot.daos;

import com.springboot.dtos.UserDto;


public interface UserDao {

//    public void registerUser(UserDto userDto);

    public boolean login(String n,String psw);
}
