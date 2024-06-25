package com.ohgiraffers.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {
    private String memberName;
    private String memberId;
    private String memberPassword;
    private String memberPhoneNumber;
    private String memberIdentityNumber;
    private Date memberRegisteredDate;
    private String memberEmail;
}
