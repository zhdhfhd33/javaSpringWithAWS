package com.SpringBoot.web.Dto;

import com.SpringBoot.web.dto.HelloResponseDto;
import org.junit.Test;

//junit이 아니라 assertj라는 것을 사용했다.assertj도 Junit에서 자동으로 라이브러리 등록을 해준다. CoreMatchers라이브러리보다 편하다고 함.
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
