package com.spread.libserver.doer.doconfig;

import com.spread.libserver.doer.dofactory.Operation;
import com.spread.libserver.mapper.*;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Make mappers present, which will be used among controllers.
 */
@RestControllerAdvice
public class ControllerConfig {
    public ControllerConfig(BookMapper bookMapper,
                            AccountMapper accountMapper,
                            CategoryMapper categoryMapper,
                            BorrowMapper borrowMapper,
                            TokenMapper tokenMapper) {
        Operation.setAllMapper(categoryMapper, bookMapper, accountMapper, borrowMapper, tokenMapper);
    }
}
