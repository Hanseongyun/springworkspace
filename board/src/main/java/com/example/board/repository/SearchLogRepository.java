package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.entity.SearchLogEntity;

public interface SearchLogRepository extends JpaRepository<SearchLogEntity,Integer>{
    
}
