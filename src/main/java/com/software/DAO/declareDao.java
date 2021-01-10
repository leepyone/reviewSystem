package com.software.DAO;


import com.software.MODULE.Declare;
import com.software.MODULE.Declare_check;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface declareDao {

    @Select("select * FROM `declare`")
    public List<Declare> getAllDeclare();//获取所有评审单

    @Select("select * FROM `declare`where declare.user_ID=#{userID}")
    public List<Declare> getDeclareByUserID(int userID);//根据用户ID获取评审单List

    @Select("select * FROM `declare`where declare.declare_ID=#{declareID}")
    public Declare getDeclareByDeclareID(int declareID);//根据评审单ID获取评审单

    @Select("select * FROM `declare`where declare.corporation_ID=#{CorporationID}")
    public List<Declare> getDeclareByCorporationID(int CorporationID);//根据公司ID获取评审单列表List

    @Select("select * FROM `declare`where declare.declare_year=#{year}")
    public List<Declare> getDeclareByYear(String year);//根据评审年度查询评审单列表List

    @Select("select * FROM `declare`where declare.declare_user_name=#{userName}")
    public List<Declare> getDeclareByUserName(String userName);//根据用户姓名查询评审单列表List

    @Select("select * FROM `declare`where declare.declare_level=#{level}")
    public List<Declare> getDeclareByLevel(int level);//根据拟评级别查询评审单列表List

    @Select("select * FROM  `declare` WHERE `declare`.declare_status=#{status}")
    public List<Declare> getDeclareByStatus(int status);//根据评审状态查询评审单列表List

    @Select("select * FROM  `declare` WHERE `declare`.declare_user_identifynumber=#{identifynumber}")
    public Declare getDeclareByIdentifyNumber(String identifynumber);//根据身份证号查询评审表单List

    @Select("select * FROM  `declare` WHERE `declare`.declare_qualification=#{qualification}")
    public List<Declare> getDeclareByQualification(String qualification);//根据申报资格名称查询评审表单List

    @Insert("insert into `declare` (`declare_ID`,`user_ID`, `declare_year`,`declare_user_name`," +
            "`corporation_ID`,`declare_corID`,`declare_status`,`declare_user_sex`," +
            "`declare_user_identifynumber`,`declare_user_birthday`,`declare_user_nation`," +
            "`declare_user_hometown`,`declare_user_phone`,`declare_user_email`,`declare_level`," +
            "`declare_professional_series`, `declare_politics`,`declare_time`,`declare_explain`, " +
            "`declare_institution`, `declare_communicate`, `declare_setuptime`,`declare_personcharacter`, " +
            "`declare_isfirst`,`declare_lasttime`, `declare_worktime`, `declare_timelimit`,`declare_method`," +
            "`declare_wenttime`,`declare_corperation_level`, `declare_politics_post` ,`declare_qualification` ," +
            "`declare_series`) " +
            "VALUES(#{declare_ID},#{user_ID}, #{declare_year},#{declare_user_name}," +
            "#{corporation_ID},#{declare_corID},#{declare_status},#{declare_user_sex}," +
            "#{declare_user_identifynumber},#{declare_user_birthday},#{declare_user_nation}," +
            "#{declare_user_hometown},#{declare_user_phone},#{declare_user_email},#{declare_level}," +
            "#{declare_professional_series}, #{declare_politics},#{declare_time},#{declare_explain}, " +
            "#{declare_institution}, #{declare_communicate}, #{declare_setuptime},#{declare_personcharacter}, " +
            "#{declare_isfirst},#{declare_lasttime}, #{declare_worktime}, #{declare_timelimit},#{declare_method}," +
            "#{declare_wenttime},#{declare_corperation_level}, #{declare_politics_post},#{declare_qualification}," +
            "#{declare_series})")
    @Options(useGeneratedKeys = true, keyProperty = "declareID", keyColumn = "declareID")
    public int InsertDeclare(Declare declare);//创建Declare评审表，
                                            // declare_time,declare_lasttime,declare_worktime三个日期字段的格式为'nn-mm-rr',declare_status状态初始值为0未审批

    @Update("UPDATE `declare` SET declare.declare_status=#{status} where declare.declare_ID=#{declareID}")
    public void setState(int status,int declareID);//更新评审表状态

    @Insert("insert into declare_check (`check_id`,`check_date`,`declare_id`,`user_id`,`check_oppoins`,`check_status`)values(#{checkId},#{checkDate},#{declareId},#{userId},#{checkOppoins},#{checkStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "declareId", keyColumn = "declareId")
    public int InsertDeclareCheck(Declare_check declareCheck);//插入declare_check表


    @Select("select * from declare_check where user_id=#{user_id}")
    public List<Declare_check> getDeclareCheckListByUserId(int user_id);//通过用户id获取declare_check的list

    @Select("select * from declare_check where declare_id=#{declare_id}")
    public List<Declare_check> getDeclareCheckListByDeclareId(int declare_id);//通过评审表id获取相应declare_check对象

    @Delete("DELETE FROM `declare` WHERE `declare`.declare_ID=#{declareID}")
    public void deleteDeclare(int declareID);//通过评审表id删除相应评审表


}
