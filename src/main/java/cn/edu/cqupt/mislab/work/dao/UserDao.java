package cn.edu.cqupt.mislab.work.dao;

import cn.edu.cqupt.mislab.work.domain.entity.User;
import cn.edu.cqupt.mislab.work.domain.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    Boolean registerUser(@Param("id")String id,@Param("userName")String userName,@Param("password")String password,@Param("email")String email,@Param("role")Integer role);

    UserPo loginUser(@Param("id")String id,@Param("password")String password);

}
