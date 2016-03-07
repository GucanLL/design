package math.design.base.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import math.design.base.model.BaseClass;

public class BaseClassSqlProvider {

    public String insertSelective(BaseClass record) {
        BEGIN();
        INSERT_INTO("math_classes");
        
        if (record.getClassId() != null) {
            VALUES("CLASS_ID", "#{classId,jdbcType=VARCHAR}");
        }
        
        if (record.getClassTeacherId() != null) {
            VALUES("CLASS_TEACHER_ID", "#{classTeacherId,jdbcType=VARCHAR}");
        }
        
        if (record.getClassNumber() != null) {
            VALUES("CLASS_NUMBER", "#{classNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEnable() != null) {
            VALUES("IS_ENABLE", "#{isEnable,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(BaseClass record) {
        BEGIN();
        UPDATE("math_classes");
        
        if (record.getClassTeacherId() != null) {
            SET("CLASS_TEACHER_ID = #{classTeacherId,jdbcType=VARCHAR}");
        }
        
        if (record.getClassNumber() != null) {
            SET("CLASS_NUMBER = #{classNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEnable() != null) {
            SET("IS_ENABLE = #{isEnable,jdbcType=VARCHAR}");
        }
        
        WHERE("CLASS_ID = #{classId,jdbcType=VARCHAR}");
        
        return SQL();
    }
}