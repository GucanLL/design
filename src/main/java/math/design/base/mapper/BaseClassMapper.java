package math.design.base.mapper;

import math.design.base.model.BaseClass;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseClassMapper {
    @Delete({
        "delete from math_classes",
        "where CLASS_ID = #{classId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String classId);

    @Insert({
        "insert into math_classes (CLASS_ID, CLASS_TEACHER_ID, ",
        "CLASS_NUMBER, IS_ENABLE)",
        "values (#{classId,jdbcType=VARCHAR}, #{classTeacherId,jdbcType=VARCHAR}, ",
        "#{classNumber,jdbcType=VARCHAR}, #{isEnable,jdbcType=VARCHAR})"
    })
    int insert(BaseClass record);

    @InsertProvider(type=BaseClassSqlProvider.class, method="insertSelective")
    int insertSelective(BaseClass record);

    @Select({
        "select",
        "CLASS_ID, CLASS_TEACHER_ID, CLASS_NUMBER, IS_ENABLE",
        "from math_classes",
        "where CLASS_ID = #{classId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="CLASS_ID", property="classId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="CLASS_TEACHER_ID", property="classTeacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLASS_NUMBER", property="classNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_ENABLE", property="isEnable", jdbcType=JdbcType.VARCHAR)
    })
    BaseClass selectByPrimaryKey(String classId);

    @UpdateProvider(type=BaseClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BaseClass record);

    @Update({
        "update math_classes",
        "set CLASS_TEACHER_ID = #{classTeacherId,jdbcType=VARCHAR},",
          "CLASS_NUMBER = #{classNumber,jdbcType=VARCHAR},",
          "IS_ENABLE = #{isEnable,jdbcType=VARCHAR}",
        "where CLASS_ID = #{classId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BaseClass record);
}