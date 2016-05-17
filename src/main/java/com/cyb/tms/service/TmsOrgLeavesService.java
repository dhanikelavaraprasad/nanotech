package com.cyb.tms.service;

import java.util.List;

import com.cyb.tms.entity.TmsOrgLeaves;

public interface TmsOrgLeavesService {

	public long createLeave(TmsOrgLeaves leave);
    public TmsOrgLeaves updateLeave(TmsOrgLeaves leave);
    public void deleteLeave(long id);
    public List<TmsOrgLeaves> getAllLeaves();
    public TmsOrgLeaves getLeave(long id);
    
}
