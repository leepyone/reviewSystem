package com.software.SERVICE;

import com.software.MODULE.Judge_check;
import com.software.MODULE.User;
import com.software.MODULE.title_judge;

import java.util.List;

public interface PersonalJudgeService {

    //根据用户id返回职称认定表list
    public List<title_judge> getTitleJudgeByUserID(User user);

    //根据认定表id返回相应认定表
    public title_judge getTitleJudgeByJudgeID(title_judge titleJudge);

    //根据认定表id返回相应认定状态表list
    public List<Judge_check> getJudgeCheckByJudgeId(title_judge titleJudge);

    //新增认定表
    public void addTitleJudge(title_judge titleJudge,User user);
}
