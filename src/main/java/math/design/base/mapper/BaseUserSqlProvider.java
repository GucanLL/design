package math.design.base.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import math.design.base.model.BaseUser;

public class BaseUserSqlProvider {

    public String insertSelective(BaseUser record) {
        BEGIN();
        INSERT_INTO("math_user");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentityNum() != null) {
            VALUES("IDENTITY_NUM", "#{identityNum,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("NAME", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIdNumber() != null) {
            VALUES("ID_NUMBER", "#{idNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            VALUES("SEX", "#{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getNationality() != null) {
            VALUES("NATIONALITY", "#{nationality,jdbcType=VARCHAR}");
        }
        
        if (record.getHeadImg() != null) {
            VALUES("HEAD_IMG", "#{headImg,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentityImg() != null) {
            VALUES("IDENTITY_IMG", "#{identityImg,jdbcType=VARCHAR}");
        }
        
        if (record.getPoliticalStatus() != null) {
            VALUES("POLITICAL_STATUS", "#{politicalStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getJobTitle() != null) {
            VALUES("JOB_TITLE", "#{jobTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("EMAIL", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAcademy() != null) {
            VALUES("ACADEMY", "#{academy,jdbcType=VARCHAR}");
        }
        
        if (record.getAtClass() != null) {
            VALUES("AT_CLASS", "#{atClass,jdbcType=VARCHAR}");
        }
        
        if (record.getMajorResearch() != null) {
            VALUES("MAJOR_RESEARCH", "#{majorResearch,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("ADDRESS", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getAdmissionDate() != null) {
            VALUES("ADMISSION_DATE", "#{admissionDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBirthday() != null) {
            VALUES("BIRTHDAY", "#{birthday,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemarks() != null) {
            VALUES("REMARKS", "#{remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getSchoolLength() != null) {
            VALUES("SCHOOL_LENGTH", "#{schoolLength,jdbcType=VARCHAR}");
        }
        
        if (record.getRole() != null) {
            VALUES("ROLE", "#{role,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("PASSWORD", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getAddBy() != null) {
            VALUES("ADD_BY", "#{addBy,jdbcType=VARCHAR}");
        }
        
        if (record.getLastModifyTime() != null) {
            VALUES("LAST_MODIFY_TIME", "#{lastModifyTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(BaseUser record) {
        BEGIN();
        UPDATE("math_user");
        
        if (record.getIdentityNum() != null) {
            SET("IDENTITY_NUM = #{identityNum,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("NAME = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIdNumber() != null) {
            SET("ID_NUMBER = #{idNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            SET("SEX = #{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getNationality() != null) {
            SET("NATIONALITY = #{nationality,jdbcType=VARCHAR}");
        }
        
        if (record.getHeadImg() != null) {
            SET("HEAD_IMG = #{headImg,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentityImg() != null) {
            SET("IDENTITY_IMG = #{identityImg,jdbcType=VARCHAR}");
        }
        
        if (record.getPoliticalStatus() != null) {
            SET("POLITICAL_STATUS = #{politicalStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getJobTitle() != null) {
            SET("JOB_TITLE = #{jobTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("EMAIL = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAcademy() != null) {
            SET("ACADEMY = #{academy,jdbcType=VARCHAR}");
        }
        
        if (record.getAtClass() != null) {
            SET("AT_CLASS = #{atClass,jdbcType=VARCHAR}");
        }
        
        if (record.getMajorResearch() != null) {
            SET("MAJOR_RESEARCH = #{majorResearch,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("ADDRESS = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getAdmissionDate() != null) {
            SET("ADMISSION_DATE = #{admissionDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBirthday() != null) {
            SET("BIRTHDAY = #{birthday,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemarks() != null) {
            SET("REMARKS = #{remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getSchoolLength() != null) {
            SET("SCHOOL_LENGTH = #{schoolLength,jdbcType=VARCHAR}");
        }
        
        if (record.getRole() != null) {
            SET("ROLE = #{role,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("PASSWORD = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getAddBy() != null) {
            SET("ADD_BY = #{addBy,jdbcType=VARCHAR}");
        }
        
        if (record.getLastModifyTime() != null) {
            SET("LAST_MODIFY_TIME = #{lastModifyTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("ID = #{id,jdbcType=VARCHAR}");
        
        return SQL();
    }
}