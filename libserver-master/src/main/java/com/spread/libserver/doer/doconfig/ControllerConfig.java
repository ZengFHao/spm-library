package com.spread.libserver.doer.doconfig;

import com.spread.libserver.doer.dofactory.Operation;
import com.spread.libserver.mapper.AccountMapper;
import com.spread.libserver.mapper.BookMapper;
import com.spread.libserver.mapper.BorrowMapper;
import com.spread.libserver.mapper.CategoryMapper;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Make mappers present, which will be used among controllers.
 */
@RestControllerAdvice
public class ControllerConfig {
    public ControllerConfig(BookMapper bookMapper,
                            AccountMapper accountMapper,
                            CategoryMapper categoryMapper,
                            BorrowMapper borrowMapper) {
        Operation.setAllMapper(categoryMapper, bookMapper, accountMapper, borrowMapper);
    }
}
