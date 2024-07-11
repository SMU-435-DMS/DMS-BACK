package com.dms.dmsback.member.dto;

import com.dms.dmsback.member.entity.pk.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String id;
    private String password;
    private LocalDate birth;
    private String name;
    private String gender; // 성별을 문자열로 변경
    private List<String> address; // 주소를 문자열 리스트로 변경
    @JsonProperty("last_login")
    private LocalDateTime lastLogin;
    private String token;

    public User toEntity() {
        return User.builder()
                .id(id)
                .password(password)
                .birth(birth)
                .name(name)
                .gender(String.valueOf(gender.charAt(0))) // 문자열에서 첫 번째 문자를 Character로 변환
                .address(address)
                .lastLogin(lastLogin)
                .token(token)
                .build();
    }

}
