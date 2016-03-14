package math.design.base.mapper;

import java.util.List;

import math.design.base.model.BaseRole;
import math.design.base.model.BaseUser;

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
public interface BaseRoleMapper {
    @Delete({
        "delete from math_role",
        "where ROLE_ID = #{roleId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String roleId);

    @Insert({
        "insert into math_role (ROLE_ID, ROLE_NAME)",
        "values (#{roleId,jdbcType=VARCHAR}, #{roleName,jdbcType=VARCHAR})"
    })
    int insert(BaseRole record);

    @InsertProvider(type=BaseRoleSqlProvider.class, method="insertSelective")
    int insertSelective(BaseRole record);

    @Select({
        "select",
        "ROLE_ID, ROLE_NAME",
        "from math_role",
        "where ROLE_ID = #{roleId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ROLE_NAME", property="roleName", jdbcType=JdbcType.VARCHAR)
    })
    BaseRole selectByPrimaryKey(String roleId);

    @UpdateProvider(type=BaseRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BaseRole record);

    @Update({
        "update math_role",
        "set ROLE_NAME = #{roleName,jdbcType=VARCHAR}",
        "where ROLE_ID = #{roleId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BaseRole record);
    

    @SelectProvider(type=BaseRoleSqlProvider.class, method="findRole")
    List<BaseRole> findRole(BaseUser user);
}