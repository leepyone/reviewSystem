package com.software.DAO;


import com.software.MODULE.Declare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface declareDao {

    @Select("select * FROM `declare`")
    public List<Declare> getAllDeclare();

    @Select("select * FROM `declare`where declare.user_ID=#{userID}")
    public List<Declare> getDeclareByUserID(int userID);


}
