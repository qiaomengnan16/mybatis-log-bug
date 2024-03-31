package org.example.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Statement;

@Intercepts({@Signature(type = StatementHandler.class, method = "parameterize", args = {Statement.class})})
public class Param2Interceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        if (target != null && target instanceof StatementHandler) {
            StatementHandler statementHandler = (StatementHandler) target;
            MetaObject metaObject = SystemMetaObject.forObject(statementHandler.getParameterHandler());
            metaObject.setValue("parameterObject", 2);
            metaObject.setValue("parameterObject", 3);
            metaObject.setValue("parameterObject", 4);
        }
        return invocation.proceed();
    }
}
