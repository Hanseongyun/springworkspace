package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
    
}
