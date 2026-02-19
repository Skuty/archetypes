package com.softwarearchetypes.scoring.ast;

public interface ExpressionVisitor<R> {
    R visit(Expression.And and);

    R visit(Expression.Or or);

    R visit(Expression.Not not);

    R visit(Expression.ConstScore constScore);

    R visit(Expression.Sum sum);

    R visit(Expression.IfThenElse ifThenElse);

    R visit(Expression.MetricCmp metricCmp);

    R visit(Expression.Labeled labeled);
}
