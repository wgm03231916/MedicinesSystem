package cn.com.servers.statisticalReport;

import java.util.List;

import cn.com.daos.statisticalReport.StatisticalDaoInf;
import cn.com.daos.statisticalReport.StatisticalDaoInfImp;

public class StatisticalServerInfImp implements StatisticalServerInf{
	private StatisticalDaoInf statisticalDaoInf = null;
	@Override
	public List<Object> getAllOfServers(Object o) {
		statisticalDaoInf = new StatisticalDaoInfImp();
		return  statisticalDaoInf.getAllOfDao(o);
	}

}
