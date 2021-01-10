package com.software;

import com.software.DAO.EducationDao;
import com.software.DAO.declareDao;
import com.software.DAO.userDao;
import com.software.MODULE.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class SystemApplicationTests {

    @Autowired
    userDao dao;
    @Autowired
    EducationDao educationDao;
    @Test
    void contextLoads() {

//        User userByIDCard = dao.getUserByIDCard("1");
//        System.out.println(userByIDCard);
//        User user = new User(0,"12","12","12",-1,-1,"12","12");
//        dao.insertUser(user);
//        System.out.println(user.getUserID());


        //System.out.println(dao.changeUserCorpId(12,8));
//        System.out.println(dao.changeUserPassword("212",8));
//        System.out.println(dao.changeUserType(12,8));
        UserDetails userDetails = new UserDetails(0,0,new Date(),"122","122","122","122","122","122","122","122","122",1,"122","122","122","122");

//        System.out.println(dao.insertUserDetail(userDetails));
        userDetails.setUserEmail("1679108504");
        System.out.println(dao.changeUserDetail(userDetails));

    }

    @Test
    void EducationTest(){
//        Education education=new Education();
//        education.setEducationGraduationProject("阿巴阿巴");
//        education.setEducationGraduationTime(new Date());
//        education.setEducationLevel("111");
//        education.setEducationMajor("111");
//        education.setUserID(1);
//        educationDao.insertEducation(education);
    }
}
