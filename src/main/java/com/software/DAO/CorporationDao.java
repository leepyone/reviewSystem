package com.software.DAO;

import com.software.MODULE.Corporation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CorporationDao {
    @Select("")
    public Corporation FindCorporation(String username);
}
