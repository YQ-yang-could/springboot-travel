package com.yang.travel.service.impl;

import com.yang.travel.mapper.MemberMapper;
import com.yang.travel.pojo.Member;
import com.yang.travel.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public Member findMemberById(Integer id) throws Exception {
        return memberMapper.findMemberById(id);
    }
}
