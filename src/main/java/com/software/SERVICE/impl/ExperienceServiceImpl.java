package com.software.SERVICE.impl;

import com.software.DAO.ExperienceDao;
import com.software.MODULE.Experience;
import com.software.MODULE.User;
import com.software.SERVICE.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    ExperienceDao experienceDao;

    //创建一条经历
    @Override
    public void addExperience(Experience experience){
        experienceDao.insertExperience(experience);
    }


    //通过用户ID返回经历集合List
    @Override
    public List<Experience> getExperienceByUserID(User user){
        int userId=user.getUserID();
        return experienceDao.getExperienceByUserID(userId);
    }

    //通过经历ID返回单个经历
    @Override
    public Experience getExperienceByEducationID(Experience experience){
        int experienceId=experience.getExperienceID();
        return experienceDao.getExperienceByEducationID(experienceId);
    }

    //根据经历ID删除单个经历
    @Override
    public void deleteExperience(Experience experience){
        int experienceId=experience.getExperienceID();
        experienceDao.deleteExperience(experienceId);
    }

    //根据经历ID更新单个经历
    @Override
    public void setExperience(Experience experience){
        experienceDao.setExperience(experience);
    }

    @Override
    public List<Experience> getExpList(int userID){ return experienceDao.getExperienceByUserID(userID); }
}
