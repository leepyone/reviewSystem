package com.software.DAO;


import com.software.MODULE.Education;
import com.software.MODULE.Experience;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExperienceDao {

    @Insert("INSERT INTO experience (`user_ID`,`experience_ID`,`experience_starttime`,`experience_endtime`,`experience_institution`,`experience_type`,`experience_status`)VALUES(#{userID},#{experienceID},#{experienceStarttime},#{experienceEndtime},#{experienceInstitution},#{experienceType},#{experienceStatus})")
    public void insertExperience(Experience experience);//创建一条经历

    @Select("SELECT experience.* FROM experience where experience.user_ID=#{userID}")
    public List<Experience> getExperienceByUserID(int userID);//通过用户ID返回经历集合List

    @Select("SELECT experience.* FROM experience where experience.experience_ID=#{experienceID}")
    public Experience getExperienceByEducationID(int experienceID);//通过经历ID返回单个经历

    @Delete("DELETE FROM experience where experience.experience_ID=#{experienceID}")
    public void deleteExperience(int experienceID);//根据经历ID删除单个经历

    @Update("UPDATE experience SET `experience_starttime`=#{experienceStarttime},`experience_endtime`=#{experienceEndtime},`experience_institution`=#{experienceInstitution},`experience_type`=#{experienceType},`experience_status`=#{experienceStatus} WHERE experience_ID=#{experienceID}")
    public void setExperience(Experience experience);//根据经历ID更新单个经历
}
