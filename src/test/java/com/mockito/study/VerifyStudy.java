package com.mockito.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class VerifyStudy {

    @Test
    @DisplayName("basic")
    public void verifyTest1() {
        MockTestClass mtc = mock(MockTestClass.class);
        mtc.setAge(32);
        verify(mtc).setAge(anyInt());
        // 해당 verify 에 정의한 setAge() 메소드가 실행 되었는지 체크함.
    }

    @Test
    @DisplayName("times")
    public void verifyTest2() {
        MockTestClass mtc = mock(MockTestClass.class);
        //times : 해당 메소드가 n번 실행되었는지 체크하는 메소드
        mtc.setAge(32);
        verify(mtc, times(5)).setAge(anyInt());
        //한 번 실행 했지만 5번 했는지 체크 하는중...
    }

    @Test
    @DisplayName("never")
    public void verifyTest3() {
        MockTestClass mtc = mock(MockTestClass.class);
        //never : 해당 메소드가 한 번도 실행되지 않았는지 체크하는 메소드
        mtc.setAge(32);
        verify(mtc, never()).setAge(anyInt());
        // 한 번도 실행되지 않았는지 체크 하는중...
    }

    @Test
    @DisplayName("atLeastOnce")
    public void verifyTest4() {
        MockTestClass mtc = mock(MockTestClass.class);
        //atLeastOnce : 해당 메소드가 최소 한 번 실행되었는지 체크하는 메소드
        mtc.setAge(32);
        verify(mtc, atLeastOnce()).setAge(anyInt());
        //최소 한 번 실행되었는지 체크 하는중...
    }

    @Test
    @DisplayName("atMostOnce")
    public void verifyTest5() {
        MockTestClass mtc = mock(MockTestClass.class);
        //atMostOnce : 해당 메소드가 최대 한 번 실행되었는지 체크하는 메소드
        mtc.setAge(32);
        verify(mtc, atMostOnce()).setAge(anyInt());
        //최대 한 번 실행되었는지 체크 하는중...
    }

    @Test
    @DisplayName("atMost")
    public void verifyTest6() {
        MockTestClass mtc = mock(MockTestClass.class);
        //atMost : 해당 메소드가 최대 n번 실행되었는지 체크하는 메소드
        mtc.setAge(32);
        verify(mtc, atMost(5)).setAge(anyInt());
        //최대 5번 실행되었는지 체크 하는중...
    }

    @Test
    @DisplayName("atLeast")
    public void verifyTest7() {
        MockTestClass mtc = mock(MockTestClass.class);
        //atMost : 해당 메소드가 최소 n번 실행되었는지 체크하는 메소드
        mtc.setAge(32);
        verify(mtc, atLeast(5)).setAge(anyInt());
        //최소 5번 실행되었는지 체크 하는중...
    }
}
