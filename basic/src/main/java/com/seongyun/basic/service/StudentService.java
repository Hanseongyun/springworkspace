package com.seongyun.basic.service;

import org.springframework.http.ResponseEntity;

import com.seongyun.basic.dto.request.student.PatchStudentRequestDto;
import com.seongyun.basic.dto.request.student.PostStudentRequestDto;

public interface StudentService {
    ResponseEntity<String> postStudent(PostStudentRequestDto dto);
    ResponseEntity<String> patchStudent(PatchStudentRequestDto dto);
    ResponseEntity<String> deleteStudent(Integer studentNumber);
}
