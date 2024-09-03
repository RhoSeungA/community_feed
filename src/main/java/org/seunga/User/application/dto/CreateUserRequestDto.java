package org.seunga.User.application.dto;

public record CreateUserRequestDto(String name, String profileImageUrl) {


}
// tostring  , equal hashcode도 자동 생성

//public class CreateUserRequestDto {
//    private final String name;
//    private final String profileImageUrl;
//
//    public String getName() {
//        return name;
//    }
//
//    public String getProfileImageUrl() {
//        return profileImageUrl;
//    }
//
//    public CreateUserRequestDto(String name, String profileImageUrl) {
//        this.name = name;
//        this.profileImageUrl=profileImageUrl;
//    }
//
//
//
//}
