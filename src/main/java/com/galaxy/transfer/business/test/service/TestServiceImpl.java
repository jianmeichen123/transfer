package com.galaxy.transfer.business.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galaxy.transfer.bean.TestBean;
import com.galaxy.transfer.dao.test.ITestDao;

@Service
public class TestServiceImpl implements ITestService{
	@Autowired
	private ITestDao dao;

	@Override
	public List<TestBean> getTestList() {
		
		return dao.getTestList();
	}

	@Override
	@Transactional
	public void saveTest(TestBean bean) {
		
		dao.saveTest(bean);
		
		double tt = 100/0;
	}
	
}
