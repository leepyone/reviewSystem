package com.software.SERVICE;

import com.software.MODULE.Experience;
import com.software.MODULE.User;

import java.util.List;

public interface ExperienceService {

    public void addExperience(Experience experience);//创建一条经历

    public List<Experience> getExperienceByUserID(User user);//通过用户ID返回经历集合List

    public Experience getExperienceByEducationID(Experience experience);//通过经历ID返回单个经历

    public void deleteExperience(Experience experience);//根据经历ID删除单个经历

    public void setExperience(Experience experience);//根据经历ID更新单个经历

    public List<Experience> getExpList(int userID);
}
