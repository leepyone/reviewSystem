package com.software.SERVICE.impl;

import com.software.DAO.TitleJudgeDao;
import com.software.MODULE.Judge_check;
import com.software.MODULE.User;
import com.software.MODULE.title_judge;
import com.software.SERVICE.PersonalJudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalJudgeServiceImpl implements PersonalJudgeService {


    @Autowired
    TitleJudgeDao titleJudgeDao;

    //根据用户id返回职称认定表list
    @Override
    public List<title_judge> getTitleJudgeByUserID(User user){
        int userId=user.getUserID();
        return titleJudgeDao.getTitleJudgeByUserID(userId);
    }

    //根据认定表id返回相应认定表
    @Override
    public title_judge getTitleJudgeByJudgeID(title_judge titleJudge){
        int titleJudgeId=titleJudge.getJudgeId();
        return titleJudgeDao.getTitleJudgeByJudgeID(titleJudgeId);
    }

    //根据认定表id返回相应认定状态表list
    @Override
    public List<Judge_check> getJudgeCheckByJudgeId(title_judge titleJudge){
        int titleJudgeId=titleJudge.getJudgeId();
        return titleJudgeDao.getJudgeCheckByJudgeId(titleJudgeId);
    }

    //新增认定表
    @Override
    public void addTitleJudge(title_judge titleJudge,User user){
        int userId=user.getUserID();
        titleJudge.setJudgeStatus(0);
        titleJudge.setUserId(userId);
        titleJudgeDao.InsertTitleJudge(titleJudge);
    }
}
