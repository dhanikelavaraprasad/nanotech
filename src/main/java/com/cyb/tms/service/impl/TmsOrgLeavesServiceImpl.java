package com.cyb.tms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyb.tms.dao.TmsOrgLeavesDAO;
import com.cyb.tms.entity.TmsOrgLeaves;
import com.cyb.tms.service.TmsOrgLeavesService;

@Service("leaveService")
@Transactional
public class TmsOrgLeavesServiceImpl implements TmsOrgLeavesService {
	
	@Autowired
	TmsOrgLeavesDAO tmsOrgLeavesDAO;

	@Override
	public long createLeave(TmsOrgLeaves leave) {
		return tmsOrgLeavesDAO.createLeave(leave);
	}

	@Override
	public TmsOrgLeaves updateLeave(TmsOrgLeaves leave) {
		return tmsOrgLeavesDAO.updateLeave(leave);
	}

	@Override
	public void deleteLeave(long id) {
		tmsOrgLeavesDAO.deleteLeave(id);
	}

	@Override
	public List<TmsOrgLeaves> getAllLeaves() {
		return tmsOrgLeavesDAO.getAllLeaves();
	}

	@Override
	public TmsOrgLeaves getLeave(long id) {
		return tmsOrgLeavesDAO.getLeave(id);
	}


}
