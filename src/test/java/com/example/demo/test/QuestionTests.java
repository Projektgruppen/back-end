//package com.example.demo.test;
//
//import com.example.demo.model.Question;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class QuestionTests {
//
//    private Question q;
//
//    @BeforeEach
//    void setup() {
//        q = new Question(10L, "Foo");
//    }
//
//    @Test
//    void getQuestionNotNull() {
//        assertNotNull(q.getQuestion());
//    }
//
//    @Test
//    void setThenGetQuestion() {
//        q.setQuestion("foo");
//        assertEquals("foo", q.getQuestion());
//    }
//
//    @Test
//    void getIdNotNull() {
//        assertNotNull(q.getId());
//    }
//
//    @Test
//    void getIdGreaterThanZero() {
//        assertTrue(q.getId() > 0);
//    }
//
//    @Test
//    void newQuestionWithNegativeIdThrowsNumberFormatException() {
//        NumberFormatException thrown = assertThrows(NumberFormatException.class,
//                () -> q = new Question(-1L, "foo")
//                ,"ID was set to negative value!"); // In case no exception is thrown show this.
//        assertNotNull(thrown.getMessage());
//    }
//
//    @Test
//    void newQuestionWithNullQuestionThrowsIllegalStateException() {
//        IllegalStateException thrown = assertThrows(IllegalStateException.class,
//                () -> q = new Question(42L, null)
//                ,"Question was initialized with null!");
//        assertNotNull(thrown.getMessage());
//    }
//
//    @Test
//    void getTimestampNotNull() {
//        assertNotNull(null); // TODO: someone removed this method: q.getTimestamp());
//    }
//
//    @Test
//    void getLikesNotLessThanZero() {
//        assertFalse(true); // TODO: someone removed this method: q.getLikes() < 0);
//    }
//
//    @Test
//    void isApproveReturnsFalseByDefault() {
//        assertFalse(q.isApprove());
//    }
//
//    @Test
//    void setApproveThenIsApproveReturnsTrue() {
//        q.setApprove(true);
//        assertTrue(q.isApprove());
//    }
//
//    @Test
//    void getStudent_idNotLessThanZero() {
//        assertFalse(true); // TODO: someone removed this method: q.getStudent_id() < 0);
//    }
//}
