package com.gaussic.repository;

import com.gaussic.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//UserRepository接口继承 JpaRepository,JpaRepository中，定义了几个简化的操作数据库的方法:findAll()、findOne(Integer id)、findByXXX(Object xxx)、save()和delete()
//但JpaRepository无update方法，需要自定义
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    @Modifying  // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update UserEntity us set  us.nickname=:qNickname, us.firstName=:qFirstName, us.lastName=:qLastName, us.password=:qPassword where us.id=:qId")
    public void updateUser(@Param("qNickname") String nickname, @Param("qFirstName") String firstName,
                           @Param("qLastName") String qLastName, @Param("qPassword") String password, @Param("qId") Integer id);


}
