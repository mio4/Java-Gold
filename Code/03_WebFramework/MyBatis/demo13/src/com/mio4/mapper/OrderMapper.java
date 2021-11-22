package com.mio4.mapper;

import com.mio4.domain.Order;

public interface OrderMapper {
    Order selectOrderById(Integer id);
}
