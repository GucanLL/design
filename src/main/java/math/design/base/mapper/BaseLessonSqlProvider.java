package math.design.base.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import math.design.base.model.BaseLesson;

public class BaseLessonSqlProvider {

    public String insertSelective(BaseLesson record) {
        BEGIN();
        INSERT_INTO("math_lessons");
        
        if (record.getClassId() != null) {
            VALUES("CLASS_ID", "#{classId,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            VALUES("CLASS_NAME", "#{className,jdbcType=VARCHAR}");
        }
        
        if (record.getClassType() != null) {
            VALUES("CLASS_TYPE", "#{classType,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherId() != null) {
            VALUES("TEACHER_ID", "#{teacherId,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherName() != null) {
            VALUES("TEACHER_NAME", "#{teacherName,jdbcType=VARCHAR}");
        }
        
        if (record.getClassYear() != null) {
            VALUES("CLASS_YEAR", "#{classYear,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEnable() != null) {
            VALUES("IS_ENABLE", "#{isEnable,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(BaseLesson record) {
        BEGIN();
        UPDATE("math_lessons");
        
        if (record.getClassName() != null) {
            SET("CLASS_NAME = #{className,jdbcType=VARCHAR}");
        }
        
        if (record.getClassType() != null) {
            SET("CLASS_TYPE = #{classType,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherId() != null) {
            SET("TEACHER_ID = #{teacherId,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherName() != null) {
        	SET("TEACHER_NAME = #{teacherName,jdbcType=VARCHAR}");
        }
        
        if (record.getClassYear() != null) {
            SET("CLASS_YEAR = #{classYear,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEnable() != null) {
            SET("IS_ENABLE = #{isEnable,jdbcType=VARCHAR}");
        }
        
        WHERE("CLASS_ID = #{classId,jdbcType=VARCHAR}");
        
        return SQL();
    }
}