package com.goumen.xiwan.service;

import com.goumen.xiwan.dao.CreditOrderMapper;
import com.goumen.xiwan.entity.BookInfo;
import com.goumen.xiwan.entity.CreditOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditOrderService {
    Logger logger=LoggerFactory.getLogger(CreditOrderService.class);

    @Autowired
    private CreditOrderMapper creditOrderMapper;

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private OtherOpertion otherOpertion;


    public CreditOrder selectByPrimaryKey(Integer id){
        return creditOrderMapper.selectByPrimaryKey(id);
    }


    public BookInfo getBookInfo(int customerId){
        CreditOrder creditOrder = creditOrderMapper.selectByCustomerId(customerId);
        //其他的opertion操作
        otherOpertion.opertion();
        return bookInfoService.selectByBookId(creditOrder.getBookId());
    }

    public CreditOrder getCreditOrder(int customerId){
        Integer cId=otherOpertion.getCustomerId(customerId);
        logger.info(cId.toString());
        return creditOrderMapper.selectByCustomerId(cId);
    }


}
