package ${entityUrl};

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * @Description:  ${entityComment}
 * @Author:       ${author}
 * @CreateDate:   ${createTime}
 * @Version:      ${version}
 *
 */
public class ${entityName} implements Serializable {

	private static final long serialVersionUID = ${agile}L;

<#list cis as ci>
    /**
    *  ${ci.comment}
    */
	<#if ci.javaType=="Date">
    <#if ci.jdbcType=="date">
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    <#elseif ci.jdbcType=="time">
    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
    <#else>
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    </#if>
    </#if>
    private ${ci.javaType} ${ci.property};

</#list>

<#list cis as ci>
    public ${ci.javaType} get${ci.property?cap_first} (){
        return ${ci.property};
    }
    public ${ci.javaType} set${ci.property?cap_first} (${ci.javaType} ${ci.property}){
        return ${ci.property} = ${ci.property};
    }

</#list>

<#if other>
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ${entityName} obj = (${entityName}) o;
        <#list cis as ci>
        if (${ci.property} != null ? !${ci.property}.equals(obj.${ci.property}) : obj.${ci.property} != null) {
            return false;
        }
        </#list>
        return false;
    }

    @Override
    public int hashCode() {
        int result = 0;
        <#list cis as ci>
        result = 31 * result + (${ci.property} != null ? ${ci.property}.hashCode() : 0);
        </#list>
        return result;
    }

    @Override
    public String toString() {
        return "${entityName}{" +
        <#list cis as ci>
            "${ci.property}='" + ${ci.property} + "'" +
        </#list>
        '}';
    }
</#if>
}
