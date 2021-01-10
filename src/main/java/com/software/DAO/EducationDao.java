package com.software.DAO;

import com.software.MODULE.Education;
import com.software.MODULE.Paper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EducationDao {

    @Insert("INSERT INTO education (`user_ID`,`education_ID`,`education_grduation_project`,`education_level`,`education_school`,`education_major`,`education_graduation_time`)VALUES(#{userID},#{educationID},#{educationGraduationProject},#{educationLevel},#{educationSchool},#{educationMajor},#{educationGraduationTime})")
    public void insertEducation(Education education);//创建一条学历记录

    @Select("SELECT education.* FROM education where education.user_ID=#{userID}")
    public List<Education> getEducationByUserID(int userID);//通过用户ID返回学历集合List

    @Select("SELECT education.* FROM education where education.education_ID=#{educationID}")
    public Education getEducationByEducationID(int educationID);//通过学历ID返回单个学历

    @Delete("DELETE FROM education where education.education_ID=#{educationID}")
    public void deleteEducation(int educationID);//根据学历ID删除单个学历

    @Update("UPDATE education SET `user_ID`=#{userID},`education_graduation_project`=#{educationGraduationProject},`education_level`=#{educationLevel},`education_school`=#{educationSchool},`education_major`=#{educationMajor},`education_graduation_time`=#{educationGraduationTime} WHERE education_ID=#{educationID}")
    public void setEducation(Education education);//根据学历ID更新单个学历


}
