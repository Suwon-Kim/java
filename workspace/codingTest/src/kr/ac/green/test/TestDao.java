package kr.ac.green.test;

import java.sql.Connection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.ac.green.AdvancedCarDao;

public class TestDao {
	private static AdvancedCarDao dao;
	private Connection con;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = AdvancedCarDao.getDao();
	}

	@Before
	public void setUp() throws Exception {
		con = dao.connect();
	}

	@After
	public void tearDown() throws Exception {
		dao.disconnect(con);
	}

	@Test
	public void testGetAll() {
		Assert.assertEquals(0, dao.getAll(con).length);
	}
	
	@Test
	public void testClear() {
		Assert.assertEquals(dao.getAll(con).length, dao.clear(con));
	}

}













