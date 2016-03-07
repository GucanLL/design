package math.design.base.mapper;

import java.util.List;

import math.design.base.model.BaseLesson;

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
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface BaseLessonMapper {
    @Delete({
        "delete from math_lessons",
        "where CLASS_ID = #{classId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String classId);

    @Insert({
        "insert into math_lessons (CLASS_ID, CLASS_NAME, ",
        "CLASS_TYPE, TEACHER_ID, TEACHER_NAME, ",
        "CLASS_YEAR, IS_ENABLE)",
        "values (#{classId,jdbcType=VARCHAR}, #{className,jdbcType=VARCHAR}, ",
        "#{classType,jdbcType=VARCHAR}, #{teacherId,jdbcType=VARCHAR}, #{teacherName,jdbcType=VARCHAR}, ",
        "#{classYear,jdbcType=VARCHAR}, #{isEnable,jdbcType=VARCHAR})"
    })
    int insert(BaseLesson record);

    @InsertProvider(type=BaseLessonSqlProvider.class, method="insertSelective")
    int insertSelective(BaseLesson record);

    @Select({
        "select",
        "CLASS_ID, CLASS_NAME, CLASS_TYPE, TEACHER_ID, TEACHER_NAME, CLASS_YEAR, IS_ENABLE",
        "from math_lessons",
        "where CLASS_ID = #{classId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="CLASS_ID", property="classId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="CLASS_NAME", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLASS_TYPE", property="classType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEACHER_ID", property="teacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEACHER_NAME", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLASS_YEAR", property="classYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_ENABLE", property="isEnable", jdbcType=JdbcType.VARCHAR)
    })
    BaseLesson selectByPrimaryKey(String classId);

    @UpdateProvider(type=BaseLessonSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BaseLesson record);

    @Update({
        "update math_lessons",
        "set CLASS_NAME = #{className,jdbcType=VARCHAR},",
          "CLASS_TYPE = #{classType,jdbcType=VARCHAR},",
          "TEACHER_ID = #{teacherId,jdbcType=VARCHAR},",
          "TEACHER_NAME = #{teacherName,jdbcType=VARCHAR},",
          "CLASS_YEAR = #{classYear,jdbcType=VARCHAR},",
          "IS_ENABLE = #{isEnable,jdbcType=VARCHAR}",
        "where CLASS_ID = #{classId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BaseLesson record);
    
    /*根据课程名称查找已有课程*/
    @Select({
        "SELECT CLASS_ID, CLASS_NAME, CLASS_TYPE, TEACHER_ID, TEACHER_NAME, CLASS_YEAR, IS_ENABLE",
        "FROM math_lessons ",
        "WHERE CLASS_NAME = #{className,jdbcType=VARCHAR} ",
        "AND IS_ENABLE = '0'"
    })
    @Results({
        @Result(column="CLASS_ID", property="classId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="CLASS_NAME", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLASS_TYPE", property="classType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEACHER_ID", property="teacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEACHER_NAME", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLASS_YEAR", property="classYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_ENABLE", property="isEnable", jdbcType=JdbcType.VARCHAR)
    })
    List<BaseLesson> countLessonsExsistByClassName(String className);
    
    @Select({
        "select",
        "CLASS_ID, CLASS_NAME, CLASS_TYPE, TEACHER_ID, TEACHER_NAME, CLASS_YEAR, IS_ENABLE",
        "from math_lessons"
    })
    @Results({
        @Result(column="CLASS_ID", property="classId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="CLASS_NAME", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLASS_TYPE", property="classType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEACHER_ID", property="teacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEACHER_NAME", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLASS_YEAR", property="classYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_ENABLE", property="isEnable", jdbcType=JdbcType.VARCHAR)
    })
    List<BaseLesson> selectAllLessons();
}