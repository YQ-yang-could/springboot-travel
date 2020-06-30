package com.yang.travel.service;

import com.yang.travel.pojo.Member;

public interface MemberService {

    public Member findMemberById(Integer id)throws Exception;
}
