package com.book.backend.pojo.dto;

import com.book.backend.pojo.Users;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 程序员小白条
 */
@Data
public class UsersDTO extends Users implements Serializable {
    private String username;
    private String password;
    public String userStatus;

    private Integer gender;

    private Integer age;

    private String tel;

    private String address;
    private String cardName;
}
