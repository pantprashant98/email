package com.springboot.Utils;

import com.springboot.dtos.UserDto;
import com.springboot.models.User;

public class UserUtils {

    public static UserDto convert(User user){

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmailId(user.getEmailId());
        userDto.setPassword(user.getPassword());
        return userDto;


    }
}
