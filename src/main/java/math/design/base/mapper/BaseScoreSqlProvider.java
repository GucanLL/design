package math.design.base.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import math.design.base.model.BaseScore;

public class BaseScoreSqlProvider {

    public String insertSelective(BaseScore record) {
        BEGIN();
        INSERT_INTO("math_score");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getLessonId() != null) {
            VALUES("LESSON_ID", "#{lessonId,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherId() != null) {
            VALUES("TEACHER_ID", "#{teacherId,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentId() != null) {
            VALUES("STUDENT_ID", "#{studentId,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            VALUES("GRADE", "#{grade,jdbcType=VARCHAR}");
        }
        
        if (record.getLessonYear() != null) {
            VALUES("LESSON_YEAR", "#{lessonYear,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEnable() != null) {
            VALUES("IS_ENABLE", "#{isEnable,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(BaseScore record) {
        BEGIN();
        UPDATE("math_score");
        
        if (record.getLessonId() != null) {
            SET("LESSON_ID = #{lessonId,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherId() != null) {
            SET("TEACHER_ID = #{teacherId,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentId() != null) {
            SET("STUDENT_ID = #{studentId,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            SET("GRADE = #{grade,jdbcType=VARCHAR}");
        }
        
        if (record.getLessonYear() != null) {
            SET("LESSON_YEAR = #{lessonYear,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEnable() != null) {
            SET("IS_ENABLE = #{isEnable,jdbcType=VARCHAR}");
        }
        
        WHERE("ID = #{id,jdbcType=VARCHAR}");
        
        return SQL();
    }
}