package math.design.base.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;


import math.design.base.model.BaseRole;
import math.design.base.model.BaseUser;

public class BaseRoleSqlProvider {

    public String insertSelective(BaseRole record) {
        BEGIN();
        INSERT_INTO("math_role");
        
        if (record.getRoleId() != null) {
            VALUES("ROLE_ID", "#{roleId,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleName() != null) {
            VALUES("ROLE_NAME", "#{roleName,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(BaseRole record) {
        BEGIN();
        UPDATE("math_role");
        
        if (record.getRoleName() != null) {
            SET("ROLE_NAME = #{roleName,jdbcType=VARCHAR}");
        }
        
        WHERE("ROLE_ID = #{roleId,jdbcType=VARCHAR}");
        
        return SQL();
    }
    public String findRole(BaseUser user) {
        BEGIN();
        SELECT("math_role");
        
        WHERE("1=1");
        if (user.getIdentityNum() != null) {
        	SET("ROLE_NAME = #{roleName,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }
}