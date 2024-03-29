package com.seongyun.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seongyun.basic.entity.StudentEntity;

// Repository 레이어 : 
// - 데이터베이스와 관련된 작업들을 처리하는 영역
// - Service가 비지니스 로직 수행 중 데이터베이스 작업이 필요할 때 Repository를 거쳐서 데이터베이스 작업을 수행

// @Repository : 해당 클래스를 Spring Bean으로 등록하는 어노테이션, @Component와 동일
// - interface에 @Repository를 사용한 이유
// - JPA를 사용하면 JpaRepository 인터페이스를 상속받은 인터페이스의 구현체를 JPA가 자동으로 생성

@Repository

public interface StudentRepository 
// JpaRepository<T, ID> : 
// - JPA 기반의 Repository를 구현하는 주요 인터페이스
// - 기본 CRUD, 정렬 기능을 제공하고 있음
// - JPA 기반 Repository를 생성할때 반드시 상속해야 함
// - 매개타입 T : 해당 Repository가 어떤 Entity의 Repository인지 나타내는 매개타입
// - 매가타입 ID : 해당 Repository에서 사용하는 Entity의 Primary key 데이터 타입을 지정하는 매개타입
extends JpaRepository<StudentEntity, Integer>{
    // Student 테이블에서 address가 '서울특별시'인 레코드를 조회
    // SQL :
    // SELECT * FROM student
    // WHERE address = '서울특별시';
    List<StudentEntity> findByAddress(String address);

    // SQL :
    // SELECT * FROM student
    // WHERE graduation IS true
    // ORDER BY age DESC;
    List<StudentEntity> findByGraduationOrderByAgeDesc(Boolean graduation);

    // SQL :
    // SELECT * FORM student
    // WHERE student_Number = 5
    // AND age > 20;
    StudentEntity findByStudentNumberAndAgeGreaterThan(Integer studentNumber, Integer Age);        // studentNumber(unique)기준 > 0~1개

    // SQL :
    // SELECT count(*) FROM student
    // WHERE graduation IS false
    int countByGraduation(Boolean graduation);

    // address가 '서울특별시' 이면서 graduation이 true인 레코드가 존재하는가?
    boolean existsByAddressAndGraduation(String address, Boolean graduation);

    // @Query :
    // - 쿼리 메서드 생성 방식만으로는 실제 SQL을 작성하는 데 한계가 있음
    // - 쿼리 메서드는 복잡한 쿼리, 조인, 서브쿼리, 그룹화를 사용할 수 없음
    // - 직접 SQL문으로 쿼리를 생성하도록 하는 어노테이션

    // 예 )
    // SELECT * FORM student
    // WHERE student_Number = 5
    // AND age > 20;

    // JPQL (Java Persistence Query Language) : 
    // 표준 SQL과 매우 흡사하지만 Entity 명과 Entity 속성으로 쿼리를 작성하는 방법
    @Query(value=
        "SELECT s FROM student s WHERE s.studentNumber = ?1 AND s.age > ?2",           // AS s
        nativeQuery = false
    )
    List<StudentEntity> getStudent2(Integer studnetNumber, Integer age);


    // Native SQL :
    // - 현재 사용하고 있는 RDBMS의 SQL문법을 그대로 따르는 방식
    @Query(
        value = "SELECT " +                                                     // 띄어쓰기 포함해줘야 됨
                    "student_number AS studentNumber, " +       // AS로 필드명 변경필요
                    "name, " +
                    "age, " +
                    "address, " +
                    "graduation " +
                "FROM student " +
                "WHERE student_number = ?1 " +                  // ?1: 첫번째 매개변수 ?2:두번째 매개변수
                "AND age > ?2 ",
                nativeQuery = true
    )
    List<StudentEntity> getStudent(Integer studentNumber, Integer age);

// 위랑 똑같은 내용
    @Query(
        value = "SELECT " +                                                   
                    "student_number AS studentNumber, " +       
                    "name, " +
                    "age, " +
                    "address, " +
                    "graduation " +
                "FROM student " +
                "WHERE student_number = :student_number " +                 
                "AND age > :age ",
                nativeQuery = true
    )
    List<StudentEntity> getStudent3(
        @Param("student_number") Integer studentNumber, 
        @Param("age") Integer age
    );
}
