package com.software.SERVICE.impl;

import com.software.DAO.EducationDao;
import com.software.MODULE.Education;
import com.software.MODULE.User;
import com.software.SERVICE.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {


    @Autowired
    EducationDao educationDao;

    //添加一条学历记录
    @Override
    public void addEducation(Education education){
        educationDao.insertEducation(education);
    }

    //通过用户ID返回学历集合List
    @Override
    public List<Education> getEducationByUserID(User user){
        int userId=user.getUserID();
        return educationDao.getEducationByUserID(userId);
    }

    //通过学历ID返回单个学历
    @Override
    public Education getEducationByEducationID(Education education) {
        int educationId=education.getEducationID();
        return educationDao.getEducationByEducationID(educationId);
    }

    //根据学历ID删除单个学历
    @Override
    public void deleteEducation(Education education){
        int educationId=education.getEducationID();
        educationDao.deleteEducation(educationId);
    }

    //根据学历ID更新单个学历
    @Override
    public void setEducation(Education education){
        educationDao.setEducation(education);
    }
}
