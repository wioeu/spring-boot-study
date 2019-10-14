package com.example.mapper;

import com.example.model.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT id,user_name,pass_word,address,email,level FROM tb_user")
    @Results({
        @Result(property = "userName",column = "user_name"),
        @Result(property = "passWord",column = "pass_word")
    })
    List<UserEntity> getAll();

    @Select("SELECT id,user_name,pass_word,address,email,level FROM tb_user WHERE id=#{id}")
    @Results({
        @Result(property = "userName",column = "user_name"),
        @Result(property = "passWord",column = "pass_word")
    })
    UserEntity getOne(String id);

    @Insert("INSERT INTO tb_user(id,user_name,pass_word,address,email,level) VALUES(#{id},#{userName},#{passWord},#{address},#{email},#{level})")
    void insertUser(UserEntity userEntity);

    @Update("UPDATE tb_user SET user_name = #{userName},pass_word = #{passWord} WHERE id = #{id}")
    void updateUser(UserEntity userEntity);

    @Delete("DELETE FROM tb_user WHERE id = #{id}")
    void deleteUser(UserEntity userEntity);

}
