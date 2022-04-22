package com.mockito.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MockitoStudy {

    @Test
    @DisplayName("가상의 객체에 실제 값을 집어넣는다.")
    public void mockingTest() {

        //mock을 이용하여 가상의 List 객체를 생성
        List mockList = mock(ArrayList.class);

        //mock List 객체에 apple 이라는 값을 집어넣어도.
        mockList.add("apple");
        //mock은 실제하지 않는 객체이기 때문에 List자체가 null 이기 때문에 값이 들어가지 않는다.
        assertEquals("apple", mockList.get(0)); // null과 "apple"의 비교이기 때문에 실패한다.
    }

    @Test
    @DisplayName("when, then을 사용하여 값을 리턴")
    public void mockingTestWhenThen() {
        List mockList = mock(ArrayList.class);

        //when 언제 : mockingList.get() 메소드를 실행할때
        //anyInt() : get() 안에 아무 int값이 들어오면
        //thenReturn : "apple" 이라는 String 값을 리턴해준다.
        when(mockList.get(anyInt())).thenReturn("apple");

        //List에 add를 하지 않았어도 위에 정의한 when을 통해 apple이라는 값이 리턴됨.
        String returnValue = mockList.get(0).toString();

        assertEquals("apple", returnValue);
    }

    @Test
    @DisplayName("when, then을 사용하여 여러 값을 리턴")
    public void mockingTestWhenThen2() {
        List mockList = mock(ArrayList.class);

        //get() 을 하면 apple을 반환
        when(mockList.get(anyInt())).thenReturn("apple");
        //size() 를 하면 10을 반환
        when(mockList.size()).thenReturn(10);

        String returnValue = mockList.get(0).toString();
        int size = mockList.size();
        assertEquals("apple", returnValue);
        assertEquals(10 , size);
    }

    @Test
    @DisplayName("return 값이 void인 메소드 테스트 수행")
    public void mockingTestDoNothing() {
        MockTestClass mtc = mock(MockTestClass.class);

        //return 값이 void인 메소드를 테스트 하기 위해서는 doNothing 이라는 메소드를 사용하여 진행한다.
        doNothing().when(mtc).setAge(anyInt());
        doNothing().when(mtc).setName(anyString());

        mtc.setAge(32);
        mtc.setName("SeungHyeon");

        //when get then이 없기때문에 assertEquals 로 비교를 못하기 떄문에 verify 를 사용하여 메소드가 실행 됬는지 여부를 체크한다.
        verify(mtc).setAge(anyInt());
        verify(mtc).setName(anyString());
    }
}

class MockTestClass {

    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

}
