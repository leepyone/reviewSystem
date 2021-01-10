package com.software.SERVICE;

import com.software.MODULE.Paper;
import com.software.MODULE.User;

import java.util.List;

public interface PaperService {

    public void addPaper(Paper paper);//创建一条论文记录

    public List<Paper> getPaperByUserID(User user);//通过用户ID返回论文集合List

    public Paper getPaperByPaperID(Paper paper);//通过论文ID返回单个论文

    public void deletePaper(Paper paper);//根据论文ID删除单个论文

    public void setPaper(Paper paper);//更新一条论文记录

    public List<Paper> getPaperList(int userID);
}
