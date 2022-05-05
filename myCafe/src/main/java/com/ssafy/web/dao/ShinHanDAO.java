package com.ssafy.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.web.vo.KB_VO;
import com.ssafy.web.vo.ShinHanVO;

@Repository
public class ShinHanDAO {
	@Autowired
	SqlSession sqlSession;
	
	public long selectAmount(ShinHanVO vo) {
		return sqlSession.selectOne("mapper.shinhan.selectAmount", vo);
	}
	
	public void updateAmount(ShinHanVO vo) {
		sqlSession.update("mapper.shinhan.updateAmount", vo);
	}
}

