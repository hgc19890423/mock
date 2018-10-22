package com.goumen.xiwan.service;

import com.goumen.xiwan.dao.UserInfoMapper;
import com.goumen.xiwan.entity.BookInfo;
import com.goumen.xiwan.entity.CreditOrder;
import com.goumen.xiwan.entity.Employee;
import com.goumen.xiwan.entity.UserInfo;
import com.goumen.xiwan.utils.EmployeeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private CreditOrderService creditOrderService;

    @Autowired
    private OtherOpertion otherOpertion;

    @Value("${notify.email.to}")
    private List<String> emails;

    public UserInfo selectByPrimaryKey(Integer id){
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public BookInfo getBookInfo(int customerId){
        return  creditOrderService.getBookInfo(customerId);
    }

    public CreditOrder getCreditOrder(int customerId){
        return creditOrderService.getCreditOrder(customerId);
    }

    public void add(int i){
        otherOpertion.add(i);
    }

    public int operton(){
          ForNew forNew= new ForNew();
          return  forNew.add();
    }

    public void opertionVoid(){
        ForNew forNew= new ForNew();
        forNew.get(1);
    }

    public int getEmployeeCount() {
        return EmployeeUtils.getEmployeeCount();
    }

    public void createEmployee(Employee employee) {
        EmployeeUtils.persistenceEmployee(employee);
    }

    //validate
    public void selectUserInfoByCustomerId(@Valid UserInfo userInfo){
        System.out.println("validate=====================");
    }

    //customerEditer
    public void printEmail(){
        emails.forEach(e ->{
            System.out.println(e);
        });
    }
}
