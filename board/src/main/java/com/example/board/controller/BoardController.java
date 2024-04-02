package com.example.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.response.board.GetLatestListResponseDto;
import com.example.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor            // final로 생성된 필드(service) 생성자 만들기
public class BoardController {
    
    private final BoardService boardService;    // 서비스 불러오기

    @GetMapping("/latest-list")
    public ResponseEntity<? super GetLatestListResponseDto> getLatestList () {       // <? super GetLatestListResponseDto와 상위(ResposeDto)까지 반환가능
        return null;
    }
}
