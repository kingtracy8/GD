package com.tracy.gd.IDao;

import com.tracy.gd.domain.ExpenseRatio;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRatioMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(ExpenseRatio record);

    int insertSelective(ExpenseRatio record);

    ExpenseRatio selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(ExpenseRatio record);

    int updateByPrimaryKey(ExpenseRatio record);
}