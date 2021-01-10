package com.software.SERVICE.impl;

import com.software.DAO.PaperDao;
import com.software.MODULE.Paper;
import com.software.MODULE.User;
import com.software.SERVICE.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperDao paperDao;

    //创建一条论文记录
    @Override
    public void addPaper(Paper paper){
        paperDao.insertPaper(paper);
    }

    //通过用户ID返回论文集合List
    @Override
    public List<Paper> getPaperByUserID(User user){
        int userId=user.getUserID();
        return paperDao.getPaperByUserID(userId);
    }

    //通过论文ID返回单个论文
    @Override
    public Paper getPaperByPaperID(Paper paper){
        int paperId=paper.getPaperID();
        return paperDao.getPaperByPaperID(paperId);
    }

    //根据论文ID删除单个论文
    @Override
    public void deletePaper(Paper paper){
        int paperId=paper.getPaperID();
        paperDao.deletePaper(paperId);
    }

    //更新一条论文记录
    @Override
    public void setPaper(Paper paper){
        paperDao.setPaper(paper);
    }
}
