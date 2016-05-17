package com.cyb.tms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyb.tms.dao.TmsOrgLeavesDAO;
import com.cyb.tms.entity.TmsOrgLeaves;
import com.cyb.tms.util.HibernateUtil;

@Repository
public class TmsOrgLeavesDAOImpl implements TmsOrgLeavesDAO {
	
	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public long createLeave(TmsOrgLeaves leave) {
		return (long) hibernateUtil.create(leave);
	}

	@Override
	public TmsOrgLeaves updateLeave(TmsOrgLeaves leave) {
		return hibernateUtil.update(leave);
	}

	@Override
	public void deleteLeave(long id) {
		TmsOrgLeaves leave = new TmsOrgLeaves();
		leave.setId(id);
		hibernateUtil.delete(leave);
		
	}

	@Override
	public List<TmsOrgLeaves> getAllLeaves() {
		return hibernateUtil.fetchAll(TmsOrgLeaves.class);
	}

	@Override
	public TmsOrgLeaves getLeave(long id) {
		return hibernateUtil.fetchById(id, TmsOrgLeaves.class);
	}

	

}
