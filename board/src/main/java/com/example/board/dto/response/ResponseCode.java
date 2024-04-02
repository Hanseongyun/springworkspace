package com.example.board.dto.response;


// respose의 코드들을 정리하기 위해 생성함
public interface ResponseCode {
    
    // 200
    String SUCCESS = "SU";

    // 400
    String VALIDATION_FAIL = "VF";
    String DUPLICATE_EMAIL = "DE";
    String DUPLICATE_NICKNAME = "DN";
    String DUPLICATE_TEL_NUMBER = "DT";
    String NOT_EXIST_USER = "NU";
    String NOT_EXIST_BOARD = "NB";

    // 401
    String SIGN_IN_FAIL = "SF";
    String AUTHORIZATION_FAIL = "AF";
    String NO_PERMISSION = "NP";

    // 500
    String DATABASE_ERROR = "DBE";

}
