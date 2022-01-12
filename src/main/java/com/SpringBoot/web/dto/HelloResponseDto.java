package com.SpringBoot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//아래의 어노테이션 둘 다 롬복임. final이 없는 필드는 생성자에 포함되지 않는다. 선언된 모든 final 필드가 포함된 생성자를 생성한다.
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;



}
