package com.software.SERVICE;

import com.software.MODULE.Education;

import java.util.List;

public interface EducationService {

    public void addEducation(Education education);//添加一条学历记录

    public List<Education> getEducationByUserID(int userID);//通过用户ID返回学历集合List

    public Education getEducationByEducationID(int educationID);//通过学历ID返回单个学历

    public void deleteEducation(int educationID);//根据学历ID删除单个学历

    public void setEducation(Education education);//根据学历ID更新单个学历
}
