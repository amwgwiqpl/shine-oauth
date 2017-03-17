package com.shine.web.mapper;

import com.shine.web.model.Developer;

import tk.mybatis.mapper.common.Mapper;

public interface DeveloperMapper extends Mapper<Developer> {

  Developer queryByClientId(String clientId);
}
