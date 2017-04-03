package com.belong.dao;

import com.belong.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Map;
@Mapper
public interface UserMapper {

    @Select({
            "select * from user " +
            "where username = #{username,jdbcType=VARCHAR}," +
            "password = #{password,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="pagenum", property="pagenum", jdbcType=JdbcType.INTEGER),
            @Result(column="pic", property="pic", jdbcType=JdbcType.LONGVARBINARY)
    })
    User login(Map map);


    @Update({
        "update user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "pagenum = #{pagenum,jdbcType=INTEGER},",
          "pic = #{pic,jdbcType=LONGVARBINARY}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(User record);

    @Update({
        "update user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "pagenum = #{pagenum,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}
