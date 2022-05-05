package com.ssafy.web.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.web.dao.OrderDAO;
import com.ssafy.web.vo.OrderVO;

@Service
public class OrderService {
	@Autowired
	OrderDAO orderDAO;
	
	public long ordersInsert(ArrayList<OrderVO> list) throws Exception{
		return orderDAO.ordersInsert(list);
	}


}
