package com.goumen.xiwan.service;

import org.springframework.stereotype.Service;

@Service
public class OtherOpertion {

    public void opertion(){
        System.out.println("其他操作");
    }

    public int getCustomerId(int customerId){
        int cId=customerId;
        return cId;
    }

    public void add(int i){
        throw new RuntimeException();
    }
}
