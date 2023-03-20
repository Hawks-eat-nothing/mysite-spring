package com.yaxingguo.mysitespring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2023-03-18 20:55:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -34115069111263096L;
    
    private Long id;
    
    private String userName;
    
    private String nickname;
    
    private String password;
    
    private String type;
    
    private String status;
    
    private String email;
    
    private String phoneNumber;
    
    private String gender;
    
    private String avatar;
    /**
     * 创建人的用户id
     */
    private Long createdBy;
    
    private Date createTime;
    
    private Integer delFlag;




}

