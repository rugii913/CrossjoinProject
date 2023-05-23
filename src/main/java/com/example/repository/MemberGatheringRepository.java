package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberGatheringRepository {

	int estimateAuthority(int memberId, int gatheringId);
}
