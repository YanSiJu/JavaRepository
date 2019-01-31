package com.heyong.lenrn_net.POJO;

import com.heyong.lenrn_net.Enums.SexEnums;
import com.heyong.lenrn_net.Enums.UserCategoryEnums;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**用户表
 * Create By Yong
 */

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //用户id
    private Integer userId;

    //用户姓名、昵称
    private String userName;

    //用户密码
    private String userPassword;

    //用户性别 默认‘男’
    private char userSex = SexEnums.MAN.getMessage();

    //用户手机号码
    private Long userTel;

    //用户类别（‘教师’或‘学生’） 默认为学生
    private String userCategory = UserCategoryEnums.STUDENT.getMessage();

    //用户描述
    private String userDescription;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex=" + userSex +
                ", userTel=" + userTel +
                ", userCategory='" + userCategory + '\'' +
                ", userDescription='" + userDescription + '\'' +
                '}';
    }
}







