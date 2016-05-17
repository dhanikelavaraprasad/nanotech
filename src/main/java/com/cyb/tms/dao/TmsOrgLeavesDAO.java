package com.cyb.tms.dao;

import java.util.List;

import com.cyb.tms.entity.TmsOrgLeaves;
import com.cyb.tms.entity.TmsUsers;

public interface TmsOrgLeavesDAO {

	public long createLeave(TmsOrgLeaves leave);
    public TmsOrgLeaves updateLeave(TmsOrgLeaves leave);
    public void deleteLeave(long id);
    public List<TmsOrgLeaves> getAllLeaves();
    public TmsOrgLeaves getLeave(long id);
    
}
