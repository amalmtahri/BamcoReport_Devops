package com.application.bamcoreport.DTO.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChangePasswordDto {

    private String username;
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;

}
