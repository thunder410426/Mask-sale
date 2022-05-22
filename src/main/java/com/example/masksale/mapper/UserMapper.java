package com.example.masksale.mapper;

import com.example.masksale.entity.User;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (id, nick_name, ",
        "registe_time)",
        "values (#{id,jdbcType=INTEGER}, #{nickName,jdbcType=VARCHAR}, ",
        "#{registeTime,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    @Select({
        "select",
        "id, nick_name, registe_time",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="registe_time", property="registeTime", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, nick_name, registe_time",
        "from user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="registe_time", property="registeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="open_id", property="openId")
    })
    List<User> selectAll();

    @Update({
        "update user",
        "set nick_name = #{nickName,jdbcType=VARCHAR},",
          "registe_time = #{registeTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);

    @Select({
            "select *",
            "from user",
            "where nick_name = #{nickName, jdbcType=VARCHAR}"

    })
    List<User> selectUserIfExits(String nickName);

    List<User> selectUser(@Param("nickName") String nickName);
}