package com.tracy.gd.IDao;

import com.tracy.gd.domain.LendingHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LendingHistoryMapper {
    int deleteByPrimaryKey(Integer lhId);

    int insert(LendingHistory record);

    int insertSelective(LendingHistory record);

    LendingHistory selectByPrimaryKey(Integer lhId);

    int updateByPrimaryKeySelective(LendingHistory record);

    int updateByPrimaryKey(LendingHistory record);

    LendingHistory selectByLaId(Integer laId);

    int deleteByPkAndUser(LendingHistory record);

    //通过la_id去查看审核详情  2017-11-16 14:58:10  linsong.wei
    LendingHistory selectDetailByLaId(Integer laId);

    List<LendingHistory> selectAll(@Param("start") Integer start, @Param("offset") Integer offset);

    List<LendingHistory> selectAddFilter(@Param("cptName") String cptName, @Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo, @Param("eIsReturned") String eIsReturned,@Param("start") Integer start, @Param("offset") Integer offset);

    int selectAllCount();

}