package com.jforce.pollsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jforce.pollsystem.entity.Poll;


@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

}
