package com.software.DAO;


import com.software.MODULE.User;
import com.software.MODULE.UserDetails;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userDao {
/**
 * 个人的部分
 * 1、注册
 * 2、查询
 *
 */


    //账号密码登录
    @Select("select * from user where `user`.user_number=#{user_number} and `user`.user_password=#{user_password}")
    User Login(String user_number,String user_password);

    //根据身份证查询用户
    @Select("select * from user where `user`.user_identifyID=#{userIdentifyID}")
    User getUserByIDCard(String userIdentifyID);

    //根据电话号码查询用户
    @Select("select * from user where `user`.user_phone=#{user_phone}")
    User getUserByPhone(String user_phone);

    //插入用户信息
    @Insert("insert into  `user` values(NULL,#{userNumber},#{userPassword},#{userName},#{userType},#{userCorpID},#{userIdentifyID},#{userPhone})")
    @Options(useGeneratedKeys = true, keyProperty = "userID", keyColumn = "user_ID")
    int insertUser(User user);


    //修改用户的密码
    @Update("update `user` set `user`.user_password=#{userPassword}  where `user`.user_number=#{user_number}")
    boolean changeUserPassword(String userPassword,String user_number);

    //修改用户的类别
    @Update("update `user` set `user`.user_type=#{userType}  where `user`.user_ID=#{userId}")
    boolean changeUserType(int userType,int userId);

    //修改用户的公司id
    @Update("update `user` set `user`.user_corpID=#{CorpId}  where `user`.user_ID=#{userId}")
    boolean changeUserCorpId(int CorpId,int userId);


    //插入一条用户详细信息记录
    @Insert("insert into  `user_details` values(#{userID},#{userSex},#{userBirthday},#{userHometown},#{userLiveplace},#{userEmail},#{userQQ},#{userProfile},#{userEducation},#{userWorkexp},#{userTitle},#{politicsStatus},#{politicsStatus},#{userLanguage},#{userSpecialty},#{rewPub},#{partTime})")
//    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_ID")
    int insertUserDetail(UserDetails userDetails);

    //修改用户的详细信息
    @Update("update `user_details` set  user_details.user_sex= #{userSex},user_details.user_birthday= #{userBirthday},user_details.user_hometown= #{userHometown},user_details.user_liveplace= #{userLiveplace},user_details.user_email= #{userEmail},user_details.user_QQ= #{userQQ},user_details.user_profile= #{userProfile},user_details.user_education= #{userEducation},user_details.user_workexp= #{userWorkexp},user_details.user_title= #{userTitle},user_details.user_phone= #{userPhone},user_details.politics_status= #{politicsStatus},user_details.user_language= #{userLanguage},user_details.user_specialty= #{userSpecialty},user_details.rew_pub= #{rewPub},user_details.part_time= #{partTime} where user_details.user_ID = #{userID}")
    boolean changeUserDetail(UserDetails userDetails);



}
