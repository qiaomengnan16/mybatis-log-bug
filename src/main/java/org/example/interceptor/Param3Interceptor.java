package org.example.interceptor;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.PreparedStatement;
import java.util.Properties;

@Intercepts({@Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class})})
public class Param3Interceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        ParameterHandler target = (ParameterHandler) invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(target);
        metaObject.setValue("parameterObject", 2);
        metaObject.setValue("parameterObject", 3);
        metaObject.setValue("parameterObject", 4);
        return invocation.proceed();
    }



}
