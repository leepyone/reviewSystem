package com.software.DAO;


import com.software.MODULE.Declare;
import com.software.MODULE.Declare_check;
import com.software.MODULE.Judge_check;
import com.software.MODULE.title_judge;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TitleJudgeDao {//这个类很多函数名字长的很像，别搞混了

    @Select("SELECT title_judge.* FROM title_judge")
    public List<title_judge> getAllTitleJudge();//获取所有的认定单

    @Select("SELECT title_judge.* FROM title_judge WHERE title_judge.user_id=#{userID}")
    public List<title_judge> getTitleJudgeByUserID(int userID);//根据用户ID查询认定单List

    @Select("SELECT title_judge.* FROM title_judge WHERE title_judge.judge_id=#{judgeID}")
    public title_judge getTitleJudgeByJudgeID(int judgeID);//根据认定单ID查询指定认定单

    @Select("SELECT title_judge.* FROM title_judge WHERE title_judge.corporation_id=#{corporationID}")
    public List<title_judge> getTitleJudgeByCorporationID(int corporationID);//根据公司ID查询认定单List

    @Select("SELECT * FROM `title_judge` WHERE title_judge.judge_year=#{judgeYear}")
    public List<title_judge> getTitleJudgeByYear(String judgeYear);//根据认定年份查询认定单List

    @Select("SELECT * FROM `title_judge` WHERE title_judge.user_name=#{userName}")
    public List<title_judge> getTitleJudgeByUserName(String userName);//根据用户姓名查询认定单List

    @Select("SELECT * FROM `title_judge` WHERE title_judge.judge_level=#{level}")
    public List<title_judge> getTitleJudgeByLevel(int level);//根据拟评级别查询认定单List

    @Select("SELECT * FROM `title_judge` WHERE title_judge.judge_status=#{status}")
    public List<title_judge> getTitleJudgeByStatus(int status);//根据认定状态查询认定单List

    @Select("SELECT * FROM `title_judge` WHERE title_judge.user_identify_number=#{identifyNumber}")
    public List<title_judge> getTitleJudgeByIdentifyNumber(String identifyNumber);//根据身份证号查询认定单List

    @Select("SELECT * FROM `title_judge` WHERE title_judge.judge_title=#{title}")
    public List<title_judge> getTitleJudgeByTitle(String title);//根据拟定专业资格技术名称查询认定单List

    @Insert("INSERT INTO title_judge (`judge_id`,`user_id`,`corporation_id`,`judge_zgb`,`judge_status`,`judge_year`,`user_name`,`user_identify_number`,`judge_level`,`user_level`,`judge_title`,`judge_major`,`pic_person`,`pic_idc1`,`pic_idc2`,`work_sum`,`labor_contract`)VALUES(#{judgeId},#{userId},#{corporationId},#{judgeZgb},#{judgeStatus},#{judgeYear},#{userName},#{userIdentifyNumber},#{judgeLevel},#{userLevel},#{judgeTitle},#{judgeMajor},#{picPerson},#{picIdc1},#{picIdc2},#{workSum},#{laborContract})")
    @Options(useGeneratedKeys = true, keyProperty = "judgeId", keyColumn = "judgeId")
    public int InsertTitleJudge(title_judge titleJudge);//创建title_judge认定表

    @Update("UPDATE title_judge SET title_judge.judge_status=#{judgeStatus} WHERE title_judge.judge_id=#{judgeId}")
    public void setStatus(int judgeId,int judgeStatus);//更新认定状态

    @Insert("INSERT INTO judge_check (`check_id`,`check_date`,`judge_id`,`user_id`,`check_oppions`,`check_status`)VALUES(#{checkId},#{checkDate},#{judgeId},#{userId},#{checkOppions},#{checkStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "checkId", keyColumn = "checkId")
    public int InsertJudgeCheck(Judge_check judgeCheck);//创建Judge_check认定记录表

    @Select("SELECT judge_check.* FROM judge_check WHERE judge_check.judge_id=#{judgeId}")
    public List<Judge_check> getJudgeCheckByJudgeId(int judgeId);//根据judge_id(认定表id),查询认定记录单judge_check的List

    @Select("SELECT judge_check.* FROM judge_check WHERE judge_check.user_id=#{userId}")
    public List<Judge_check> getJudgeCheckByUserId(int userId);//根据审核人Id,查询认定记录单judge_check的List

    @Select("SELECT judge_check.* FROM judge_check WHERE judge_check.check_id=#{checkId}")
    public Judge_check getJudgeCheckByCheckId(int checkId);//根据认定记录Id(checkId),查询认定记录单judge_check的一条记录
}
