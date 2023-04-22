package com.spread.libserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spread.libserver.model.dao.Borrow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BorrowMapper extends BaseMapper<Borrow> {
}
