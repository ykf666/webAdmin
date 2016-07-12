package com.test.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.dao.ProgramExtMapper;
import com.test.app.model.ProgramExt;
import com.test.app.model.ProgramExtExample;

@Service
public class ProgramExtService {

	@Autowired
	private ProgramExtMapper programExtMapper;
	
	public List<ProgramExt> findProgramExt(int pageStart, int pageSize){
		ProgramExtExample example = new ProgramExtExample();
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		return programExtMapper.selectByExample(example);
	}
	
}
