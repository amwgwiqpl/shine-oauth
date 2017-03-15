package com.shine.mapper;

import com.shine.model.Developer;

import tk.mybatis.mapper.common.Mapper;

public interface DeveloperMapper extends Mapper<Developer> {

  Developer queryByClientId(String clientId);
}
