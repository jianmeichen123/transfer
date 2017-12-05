package com.galaxy.transfer.business.test.service;

import java.util.List;

import com.galaxy.transfer.bean.TestBean;

public interface ITestService {
	List<TestBean> getTestList();
	void saveTest(TestBean bean);
}
