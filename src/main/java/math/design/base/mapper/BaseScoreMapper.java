package math.design.base.mapper;

import java.util.List;

import math.design.base.model.BaseScore;

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
public interface BaseScoreMapper {
    @Delete({
        "delete from math_score",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into math_score (ID, LESSON_ID, ",
        "LESSON_NAME, TEACHER_ID, ",
        "TEACHER_NAME, STUDENT_ID, ",
        "STUDENT_NAME, GRADE, ",
        "LESSON_YEAR, IS_ENABLE)",
        "values (#{id,jdbcType=VARCHAR}, #{lessonId,jdbcType=VARCHAR}, ",
        "#{lessonName,jdbcType=VARCHAR}, #{teacherId,jdbcType=VARCHAR}, ",
        "#{teacherName,jdbcType=VARCHAR}, #{studentId,jdbcType=VARCHAR}, ",
        "#{studentName,jdbcType=VARCHAR}, #{grade,jdbcType=VARCHAR}, ",
        "#{lessonYear,jdbcType=VARCHAR}, #{isEnable,jdbcType=VARCHAR})"
    })
    int insert(BaseScore record);

    @InsertProvider(type=BaseScoreSqlProvider.class, method="insertSelective")
    int insertSelective(BaseScore record);

    @Select({
        "select",
        "ID, LESSON_ID, LESSON_NAME, TEACHER_ID, TEACHER_NAME, STUDENT_ID, STUDENT_NAME, ",
        "GRADE, LESSON_YEAR, IS_ENABLE",
        "from math_score",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="LESSON_ID", property="lessonId", jdbcType=JdbcType.VARCHAR),
        @Result(column="LESSON_NAME", property="lessonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEACHER_ID", property="teacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEACHER_NAME", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="STUDENT_ID", property="studentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="STUDENT_NAME", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="GRADE", property="grade", jdbcType=JdbcType.VARCHAR),
        @Result(column="LESSON_YEAR", property="lessonYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_ENABLE", property="isEnable", jdbcType=JdbcType.VARCHAR)
    })
    BaseScore selectByPrimaryKey(String id);

    @UpdateProvider(type=BaseScoreSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BaseScore record);

    @Update({
        "update math_score",
        "set LESSON_ID = #{lessonId,jdbcType=VARCHAR},",
          "LESSON_NAME = #{lessonName,jdbcType=VARCHAR},",
          "TEACHER_ID = #{teacherId,jdbcType=VARCHAR},",
          "TEACHER_NAME = #{teacherName,jdbcType=VARCHAR},",
          "STUDENT_ID = #{studentId,jdbcType=VARCHAR},",
          "STUDENT_NAME = #{studentName,jdbcType=VARCHAR},",
          "GRADE = #{grade,jdbcType=VARCHAR},",
          "LESSON_YEAR = #{lessonYear,jdbcType=VARCHAR},",
          "IS_ENABLE = #{isEnable,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BaseScore record);
    

    @Select({
    	"SELECT COUNT(1) FROM math_score ms ",
    	"WHERE ms.LESSON_ID = #{lessonId,jdbcType=VARCHAR} AND ms.STUDENT_ID=#{studentId,jdbcType=VARCHAR}"
    })
    int isExistLessonStudent(BaseScore record);
    
    @Select({
    	"select",
        "ID, LESSON_ID, LESSON_NAME, TEACHER_ID, TEACHER_NAME, STUDENT_ID, STUDENT_NAME, ",
        "GRADE, LESSON_YEAR, IS_ENABLE",
        "from math_score"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="LESSON_ID", property="lessonId", jdbcType=JdbcType.VARCHAR),
        @Result(column="LESSON_NAME", property="lessonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEACHER_ID", property="teacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEACHER_NAME", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="STUDENT_ID", property="studentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="STUDENT_NAME", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="GRADE", property="grade", jdbcType=JdbcType.VARCHAR),
        @Result(column="LESSON_YEAR", property="lessonYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_ENABLE", property="isEnable", jdbcType=JdbcType.VARCHAR)
    })
    List<BaseScore> selectAllStudentScore();
    @Select({
    	"select",
        "ID, LESSON_ID, LESSON_NAME, TEACHER_ID, TEACHER_NAME, STUDENT_ID, STUDENT_NAME, ",
        "GRADE, LESSON_YEAR, IS_ENABLE",
        "from math_score",
        "WHERE STUDENT_ID=#{studentId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="LESSON_ID", property="lessonId", jdbcType=JdbcType.VARCHAR),
        @Result(column="LESSON_NAME", property="lessonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEACHER_ID", property="teacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEACHER_NAME", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="STUDENT_ID", property="studentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="STUDENT_NAME", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="GRADE", property="grade", jdbcType=JdbcType.VARCHAR),
        @Result(column="LESSON_YEAR", property="lessonYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_ENABLE", property="isEnable", jdbcType=JdbcType.VARCHAR)
    })
    List<BaseScore> selectMyScore(String studentId);
    
    @Select({
    	"SELECT ID FROM math_score ms ",
    	"WHERE ms.LESSON_ID = #{lessonId,jdbcType=VARCHAR} AND ms.STUDENT_ID=#{studentId,jdbcType=VARCHAR}"
    })
    String selectBycondition(BaseScore record);
    
}