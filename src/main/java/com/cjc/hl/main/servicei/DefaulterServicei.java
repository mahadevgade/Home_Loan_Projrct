package com.cjc.hl.main.servicei;

import java.util.List;

import com.cjc.hl.main.entity.Defaulter;

public interface DefaulterServicei {

	public void saveDefaulter(Defaulter df);

	public List<Defaulter> getDefaulters();

}
