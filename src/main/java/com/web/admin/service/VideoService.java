package com.test.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.dao.VideoMapper;
import com.test.app.model.Video;
import com.test.app.model.VideoExample;

@Service
public class VideoService {

	@Autowired
	private VideoMapper videoMapper;
	
	public List<Video> findVideos(int pageStart, int pageSize){
		VideoExample example = new VideoExample();
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		return videoMapper.selectByExample(example);
	}
	
}
