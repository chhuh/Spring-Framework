package com.ssafy.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.web.dao.KB_DAO;
import com.ssafy.web.dao.ShinHanDAO;
import com.ssafy.web.vo.KB_VO;
import com.ssafy.web.vo.ShinHanVO;

@Service
public class BankService {
	
	@Autowired
	KB_DAO kbDAO;
	
	@Autowired
	ShinHanDAO sDAO;

	@Transactional
	public String remit(KB_VO kbvo) throws Exception {
		long balance=kbDAO.selectBalance(kbvo);
		balance-=kbvo.getRemitAmount();
		if(balance>0) {
			kbvo.setBalance(balance);
			kbDAO.updateBalance(kbvo);
			
			ShinHanVO svo=new ShinHanVO("1234567-123-12","전은수",0);
			svo.setAmount(sDAO.selectAmount(svo)+kbvo.getRemitAmount());
			sDAO.updateAmount(svo);
			return "ok";
		}
		return "fail";	
		
	}
}
