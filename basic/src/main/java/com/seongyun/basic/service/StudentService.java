package com.seongyun.basic.service;

import org.springframework.http.ResponseEntity;

import com.seongyun.basic.dto.request.student.PostStudentRequestDto;

public interface StudentService {
    ResponseEntity<String> postStudent(PostStudentRequestDto dto);
}
