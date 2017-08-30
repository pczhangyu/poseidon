package com.poseidon.search.builders;

import org.elasticsearch.index.query.QueryBuilder;

import java.util.List;


public final class DefaultQuerySearchBuilder extends BoolQuerySearchBuilder {

    private List<QueryBuilder> mustQueryBuilders;
    private List<QueryBuilder> mustNotQueryBuilders;
    private List<QueryBuilder> shouldQueryBuilders;

    public DefaultQuerySearchBuilder(List<QueryBuilder> mustQueryBuilders, List<QueryBuilder> mustNotQueryBuilders, List<QueryBuilder> shouldQueryBuilders){
        this.mustQueryBuilders = mustQueryBuilders;
        this.mustNotQueryBuilders = mustNotQueryBuilders;
        this.shouldQueryBuilders = shouldQueryBuilders;
        super.queryBuilder();
    }

    public DefaultQuerySearchBuilder(List<QueryBuilder> mustQueryBuilders, List<QueryBuilder> mustNotQueryBuilders){
        this.mustQueryBuilders = mustQueryBuilders;
        this.mustNotQueryBuilders = mustNotQueryBuilders;
        super.queryBuilder();
    }

    public DefaultQuerySearchBuilder(List<QueryBuilder> mustQueryBuilders){
        this.mustQueryBuilders = mustQueryBuilders;
        super.queryBuilder();
    }

    protected List<QueryBuilder> mustQueryBuilder(){
        return mustQueryBuilders;
    }

    protected List<QueryBuilder> mustNotQueryBuilder(){
        return mustNotQueryBuilders;
    }

    protected List<QueryBuilder> shouldQueryBuilder(){
        return shouldQueryBuilders;
    }

}
