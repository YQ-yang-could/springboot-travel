package com.yang.travel.mapper;

import com.yang.travel.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 会员接口
 */
@Repository
@Mapper
public interface MemberMapper {

        public Member findMemberById(Integer id)throws Exception;
}
