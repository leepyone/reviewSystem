package com.software.DAO;


import com.software.MODULE.Paper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PaperDao {


    @Insert("INSERT INTO paper (`user_ID`,`paper_ID`,`paper_date`,`paper_type`,`paper_name`,`paper_publication`,`paper_part`)VALUES(#{userID},#{paperID},#{paperDate},#{paperType},#{paperName},#{paperPublication},#{paperPart})")
    public void insertPaper(Paper paper);//创建一条论文记录

    @Select("SELECT paper.* FROM paper where paper.user_ID=#{userID}")
    public List<Paper> getPaperByUserID(int userID);//通过用户ID返回论文集合List

    @Select("SELECT paper.* FROM paper where paper.paper_ID=#{paperID}")
    public Paper getPaperByPaperID(int paperID);//通过论文ID返回单个论文

    @Delete("DELETE FROM paper where paper.paper_ID=#{paperID}")
    public void deletePaper(int paperID);//根据论文ID删除单个论文

    @Update("UPDATE paper SET `user_ID`=#{userID},`paper_date`=#{paperDate},`paper_type`=#{paperType},`paper_name`=#{paperName},`paper_publication`=#{paperPublication},`paper_part`=#{paperPart} WHERE paper_ID=#{paperID}")
    public void setPaper(Paper paper);//更新一条论文记录

}
