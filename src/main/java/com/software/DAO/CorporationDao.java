package com.software.DAO;

import com.software.MODULE.Corporation;
import com.software.MODULE.corporation_worker;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CorporationDao {


    //插入一条公司单位的记录
    @Insert("insert into corporation values(null,#{account},#{password},#{corporationName},#{corporationPerson},#{corporationLevel},#{corporationType},#{corporationMandator},#{corporationLocation},#{corporationAddress},#{pic1},#{pic2},#{pic3})")
    boolean insertCorporation(Corporation corporation);

    //根据公司账号查询 公司id
    @Select("select corporation.corporation_id from corporation where corporation.account = #{corporationAccount} ")
    int getCorIdByAccount(String corporationAccount);

    //根据公司账户查询公司
    @Select("select * from corporation where corporation.account=#{account}")
    Corporation FindCorporation(String account);

    //查询所有的公司
    @Select("select * from corporation")
    List<Corporation> FindAllCorporations();

    //插入一条公司 员工记录 用于给公司添加工作人员
    @Insert("insert into corporation_worker values(#{corporationId},#{userID},#{userStatus}) ")
    boolean insertCorporationWorkers(corporation_worker worker);

    //更改工作人员的启用状态
    @Update("update corporation_worker set  corporation_worker.user_status =#{userStatus}  where corporation_worker.corporation_id = #{corporationId} and corporation_worker.user_ID= #{userID}  ")
    boolean updateCorporationWorkers(corporation_worker worker);

    //删除一条公司 员工记录
    @Delete("delete from corporation_worker where corporation_worker.corporation_id= #{corporationId} and corporation_worker.user_ID= #{userId}")
    boolean deleteCorporationWorkers(int corporationId,int userId);


}
