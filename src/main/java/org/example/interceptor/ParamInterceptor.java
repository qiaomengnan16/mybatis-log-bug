package org.example.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})})
public class ParamInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        statementHandler.getParameterHandler().setParameters((PreparedStatement) invocation.getArgs()[0]);
        statementHandler.getParameterHandler().setParameters((PreparedStatement) invocation.getArgs()[0]);
        statementHandler.getParameterHandler().setParameters((PreparedStatement) invocation.getArgs()[0]);
        return invocation.proceed();
    }

}
