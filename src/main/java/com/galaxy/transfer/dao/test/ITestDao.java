package com.galaxy.transfer.dao.test;

import java.util.List;

import com.galaxy.transfer.bean.TestBean;

public interface ITestDao {
	List<TestBean> getTestList();
	void saveTest(TestBean bean);
}
