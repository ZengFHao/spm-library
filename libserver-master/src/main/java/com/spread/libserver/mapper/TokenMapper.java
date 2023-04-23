package com.spread.libserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spread.libserver.model.dao.Token;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenMapper extends BaseMapper<Token> {
}
