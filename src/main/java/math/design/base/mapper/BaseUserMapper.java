package math.design.base.mapper;

import java.util.List;

import math.design.base.model.BaseRole;
import math.design.base.model.BaseUser;
import math.design.base.model.LoginUser;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseUserMapper {
    @Delete({
        "delete from math_user",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int deleteByIdentityNum(String id);

    @Insert({
        "insert into math_user (ID, IDENTITY_NUM, ",
        "NAME, ID_NUMBER, ",
        "SEX, NATIONALITY, ",
        "HEAD_IMG, IDENTITY_IMG, ",
        "POLITICAL_STATUS, JOB_TITLE, ",
        "EMAIL, ACADEMY, ",
        "AT_CLASS, MAJOR_RESEARCH, ",
        "ADDRESS, ADMISSION_DATE, ",
        "BIRTHDAY, REMARKS, ",
        "SCHOOL_LENGTH, ROLE, ",
        "PASSWORD, ADD_BY, ",
        "LAST_MODIFY_TIME)",
        "values (#{id,jdbcType=VARCHAR}, #{identityNum,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{idNumber,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{nationality,jdbcType=VARCHAR}, ",
        "#{headImg,jdbcType=VARCHAR}, #{identityImg,jdbcType=VARCHAR}, ",
        "#{politicalStatus,jdbcType=VARCHAR}, #{jobTitle,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{academy,jdbcType=VARCHAR}, ",
        "#{atClass,jdbcType=VARCHAR}, #{majorResearch,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{admissionDate,jdbcType=TIMESTAMP}, ",
        "#{birthday,jdbcType=TIMESTAMP}, #{remarks,jdbcType=VARCHAR}, ",
        "#{schoolLength,jdbcType=VARCHAR}, #{role,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{addBy,jdbcType=VARCHAR}, ",
        "#{lastModifyTime,jdbcType=TIMESTAMP})"
    })
    int insert(BaseUser record);

    @InsertProvider(type=BaseUserSqlProvider.class, method="insertSelective")
    int insertSelective(BaseUser record);

    @Select({
        "select",
        "ID, IDENTITY_NUM, NAME, ID_NUMBER, SEX, NATIONALITY, HEAD_IMG, IDENTITY_IMG, ",
        "POLITICAL_STATUS, JOB_TITLE, EMAIL, ACADEMY, AT_CLASS, MAJOR_RESEARCH, ADDRESS, ",
        "ADMISSION_DATE, BIRTHDAY, REMARKS, SCHOOL_LENGTH, ROLE, PASSWORD, ADD_BY, LAST_MODIFY_TIME",
        "from math_user",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="IDENTITY_NUM", property="identityNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ID_NUMBER", property="idNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEX", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="NATIONALITY", property="nationality", jdbcType=JdbcType.VARCHAR),
        @Result(column="HEAD_IMG", property="headImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="IDENTITY_IMG", property="identityImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="POLITICAL_STATUS", property="politicalStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="JOB_TITLE", property="jobTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACADEMY", property="academy", jdbcType=JdbcType.VARCHAR),
        @Result(column="AT_CLASS", property="atClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="MAJOR_RESEARCH", property="majorResearch", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADMISSION_DATE", property="admissionDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BIRTHDAY", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REMARKS", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="SCHOOL_LENGTH", property="schoolLength", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADD_BY", property="addBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_MODIFY_TIME", property="lastModifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BaseUser selectByPrimaryKey(String id);

    @UpdateProvider(type=BaseUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BaseUser record);
    
    @UpdateProvider(type=BaseUserSqlProvider.class, method="updateByIdentityNumSelective")
    int updateByIdentityNumSelective(BaseUser record);

    @Update({
        "update math_user",
        "set IDENTITY_NUM = #{identityNum,jdbcType=VARCHAR},",
          "NAME = #{name,jdbcType=VARCHAR},",
          "ID_NUMBER = #{idNumber,jdbcType=VARCHAR},",
          "SEX = #{sex,jdbcType=VARCHAR},",
          "NATIONALITY = #{nationality,jdbcType=VARCHAR},",
          "HEAD_IMG = #{headImg,jdbcType=VARCHAR},",
          "IDENTITY_IMG = #{identityImg,jdbcType=VARCHAR},",
          "POLITICAL_STATUS = #{politicalStatus,jdbcType=VARCHAR},",
          "JOB_TITLE = #{jobTitle,jdbcType=VARCHAR},",
          "EMAIL = #{email,jdbcType=VARCHAR},",
          "ACADEMY = #{academy,jdbcType=VARCHAR},",
          "AT_CLASS = #{atClass,jdbcType=VARCHAR},",
          "MAJOR_RESEARCH = #{majorResearch,jdbcType=VARCHAR},",
          "ADDRESS = #{address,jdbcType=VARCHAR},",
          "ADMISSION_DATE = #{admissionDate,jdbcType=TIMESTAMP},",
          "BIRTHDAY = #{birthday,jdbcType=TIMESTAMP},",
          "REMARKS = #{remarks,jdbcType=VARCHAR},",
          "SCHOOL_LENGTH = #{schoolLength,jdbcType=VARCHAR},",
          "ROLE = #{role,jdbcType=VARCHAR},",
          "PASSWORD = #{password,jdbcType=VARCHAR},",
          "ADD_BY = #{addBy,jdbcType=VARCHAR},",
          "LAST_MODIFY_TIME = #{lastModifyTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BaseUser record);
    
    /* 登录时select用户 */
    @Select({
        "select",
        "ID, IDENTITY_NUM, NAME, PASSWORD, ACADEMY, AT_CLASS, ROLE",
        "from math_user",
        "where IDENTITY_NUM = #{identityNum,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR),
        @Result(column="IDENTITY_NUM", property="identityNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="AT_CLASS", property="atClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACADEMY", property="academy", jdbcType=JdbcType.VARCHAR),
    })
    LoginUser selectLogin(LoginUser record);
    
    @Select({
    	"SELECT ID,IDENTITY_NUM,NAME FROM math_user WHERE ROLE = #{role,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR),
        @Result(column="IDENTITY_NUM", property="identityNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<BaseUser> selectUserByRole(String role);
    
    @Select({
        "select",
        "ID, IDENTITY_NUM, NAME, ID_NUMBER, SEX, NATIONALITY, HEAD_IMG, IDENTITY_IMG, ",
        "POLITICAL_STATUS, JOB_TITLE, EMAIL, ACADEMY, AT_CLASS, MAJOR_RESEARCH, ADDRESS, ",
        "ADMISSION_DATE, BIRTHDAY, REMARKS, SCHOOL_LENGTH, ROLE, PASSWORD, ADD_BY, LAST_MODIFY_TIME",
        "from math_user"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="IDENTITY_NUM", property="identityNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ID_NUMBER", property="idNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEX", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="NATIONALITY", property="nationality", jdbcType=JdbcType.VARCHAR),
        @Result(column="HEAD_IMG", property="headImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="IDENTITY_IMG", property="identityImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="POLITICAL_STATUS", property="politicalStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="JOB_TITLE", property="jobTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACADEMY", property="academy", jdbcType=JdbcType.VARCHAR),
        @Result(column="AT_CLASS", property="atClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="MAJOR_RESEARCH", property="majorResearch", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADMISSION_DATE", property="admissionDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BIRTHDAY", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REMARKS", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="SCHOOL_LENGTH", property="schoolLength", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADD_BY", property="addBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_MODIFY_TIME", property="lastModifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BaseUser> selectAllUser();
    
    @SelectProvider(type=BaseUserSqlProvider.class, method="selectUserIf")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="IDENTITY_NUM", property="identityNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ID_NUMBER", property="idNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEX", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="NATIONALITY", property="nationality", jdbcType=JdbcType.VARCHAR),
        @Result(column="HEAD_IMG", property="headImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="IDENTITY_IMG", property="identityImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="POLITICAL_STATUS", property="politicalStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="JOB_TITLE", property="jobTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACADEMY", property="academy", jdbcType=JdbcType.VARCHAR),
        @Result(column="AT_CLASS", property="atClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="MAJOR_RESEARCH", property="majorResearch", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADMISSION_DATE", property="admissionDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BIRTHDAY", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REMARKS", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="SCHOOL_LENGTH", property="schoolLength", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADD_BY", property="addBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_MODIFY_TIME", property="lastModifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BaseUser> selectUserIf(BaseUser record);
    
    @Select({
        "select",
        "ID, IDENTITY_NUM, NAME, ID_NUMBER, SEX, NATIONALITY, HEAD_IMG, IDENTITY_IMG, ",
        "POLITICAL_STATUS, JOB_TITLE, EMAIL, ACADEMY, AT_CLASS, MAJOR_RESEARCH, ADDRESS, ",
        "ADMISSION_DATE, BIRTHDAY, REMARKS, SCHOOL_LENGTH, ROLE, PASSWORD, ADD_BY, LAST_MODIFY_TIME",
        "from math_user",
        "where IDENTITY_NUM = #{identityNum,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="IDENTITY_NUM", property="identityNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ID_NUMBER", property="idNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEX", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="NATIONALITY", property="nationality", jdbcType=JdbcType.VARCHAR),
        @Result(column="HEAD_IMG", property="headImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="IDENTITY_IMG", property="identityImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="POLITICAL_STATUS", property="politicalStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="JOB_TITLE", property="jobTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACADEMY", property="academy", jdbcType=JdbcType.VARCHAR),
        @Result(column="AT_CLASS", property="atClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="MAJOR_RESEARCH", property="majorResearch", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADMISSION_DATE", property="admissionDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BIRTHDAY", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REMARKS", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="SCHOOL_LENGTH", property="schoolLength", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADD_BY", property="addBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_MODIFY_TIME", property="lastModifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BaseUser selectByIdentityNum(String id);
}