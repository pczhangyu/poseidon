package com.poseidon.search.builders;

import org.elasticsearch.action.admin.indices.close.CloseIndexResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse;
import org.elasticsearch.client.Client;

import java.net.UnknownHostException;


public class IndexBuilder {


    /**
     * 检查索引是否存在
     * @param indexName
     * @return
     * @throws UnknownHostException
     */
    public static boolean isExists(String indexName) throws UnknownHostException {
        Client client = ClientBuilder.build();
        return client.admin().indices().prepareExists(indexName).execute().actionGet().isExists();
    }

    /**
     * 创建索引
     * @param indexName
     * @return
     * @throws UnknownHostException
     */
    public static CreateIndexResponse create(String indexName) throws UnknownHostException {
        Client client = ClientBuilder.build();
        return client.admin().indices().prepareCreate(indexName).execute().actionGet();
    }

    /**
     * 删除索引
     * @param indexName
     * @return
     * @throws UnknownHostException
     */
    public static DeleteIndexResponse delete(String indexName) throws UnknownHostException {
        Client client = ClientBuilder.build();
        return client.admin().indices().prepareDelete(indexName).execute().actionGet();
    }

    /**
     * 开启索引
     * @param indexName
     * @return
     * @throws UnknownHostException
     */
    public static OpenIndexResponse open(String indexName) throws UnknownHostException {
        Client client = ClientBuilder.build();
        return client.admin().indices().prepareOpen(indexName).execute().actionGet();
    }

    /**
     * 关闭索引
     * @param indexName
     * @return
     * @throws UnknownHostException
     */
    public static CloseIndexResponse close(String indexName) throws UnknownHostException {
        Client client = ClientBuilder.build();
        return client.admin().indices().prepareClose(indexName).execute().actionGet();
    }

}
