package com.poseidon.search.builders;

import com.alibaba.fastjson.JSON;

import com.poseidon.search.constant.Params4Search;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetRequestBuilder;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;


public class DocumentBuilder {

    /**
     * 索引文档
     * @param index
     * @param type
     * @param object
     * @return
     * @throws UnknownHostException
     */
    public static IndexResponse index(String index, String type, Object object) throws UnknownHostException {
        Client client = ClientBuilder.build();
        return client.prepareIndex(index, type).setSource(JSON.toJSONString(object)).get();
    }

    /**
     * 索引文档
     * @param index
     * @param type
     * @param id
     * @param object
     * @return
     * @throws UnknownHostException
     */
    public static IndexResponse index(String index, String type, String id, Object object) throws UnknownHostException {
        Client client = ClientBuilder.build();
        return client.prepareIndex(index, type, id).setSource(JSON.toJSONString(object)).get();
    }

    /**
     * 单索引 索引多文档
     * @param index
     * @param type
     * @param list
     * @return
     * @throws UnknownHostException
     */
    public static BulkResponse MultiIndex(String index, String type, List<Object> list) throws UnknownHostException {
        Client client = ClientBuilder.build();
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        for(Object object : list){
            bulkRequestBuilder.add(client.prepareIndex(index, type)
                    .setSource(JSON.toJSONString(object)));
        }
        return bulkRequestBuilder.execute().actionGet();
    }

    /**
     * 多索引 索引多文档
     * @param list
     * @return
     * @throws UnknownHostException
     */
    public static BulkResponse MultiIndex(List<Map<String, Object>> list) throws UnknownHostException {
        Client client = ClientBuilder.build();
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        for(Map<String, Object> map : list){
            String index = (String) map.get(Params4Search.INDEX_NAME);
            String type = (String) map.get(Params4Search.TYPE_NAME);
            String id = (String) map.get(Params4Search.DOC_ID);
            bulkRequestBuilder.add(client.prepareIndex(index, type, id)
                    .setSource(JSON.toJSONString(map.get(Params4Search.DATA_JSON))));
        }
        return bulkRequestBuilder.execute().actionGet();
    }

    /**
     * 删除文档
     * @param index
     * @param type
     * @param id
     * @return
     * @throws UnknownHostException
     */
    public static DeleteResponse delete(String index, String type, String id) throws UnknownHostException {
        Client client = ClientBuilder.build();
        return client.prepareDelete(index, type, id).get();
    }

    /**
     * 更新文档
     * @param index
     * @param type
     * @param id
     * @return
     * @throws UnknownHostException
     */
    public static UpdateResponse update(String index, String type, String id, Object object) throws UnknownHostException {
        Client client = ClientBuilder.build();
        return client.prepareUpdate(index, type, id).setDoc(JSON.toJSONString(object)).get();
    }

    /**
     * 批量更新文档
     * @param index
     * @param type
     * @param id
     * @param map
     * @return
     * @throws UnknownHostException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static UpdateResponse muiltUpdate(String index, String type, String id, Map<String,Object> map) throws UnknownHostException, ExecutionException, InterruptedException {
        Client client = ClientBuilder.build();
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index(index);
        updateRequest.type(type);
        updateRequest.id(id);
        updateRequest.doc(JSON.toJSONString(map));
        return client.update(updateRequest).get();
    }

    /**
     * 单文档查询
     * @param index
     * @param type
     * @param id
     * @return
     * @throws UnknownHostException
     */
    public static GetResponse get(String index, String type, String id) throws UnknownHostException {
        Client client = ClientBuilder.build();
        return client.prepareGet(index, type, id).get();
    }

    /**
     * 单索引 多文档查询
     * @param index
     * @param type
     * @param ids
     * @return
     * @throws UnknownHostException
     */
    public static MultiGetResponse multiGet(String index, String type, String... ids) throws UnknownHostException {
        Client client = ClientBuilder.build();
        MultiGetRequestBuilder multiGetRequestBuilder = client.prepareMultiGet();
        multiGetRequestBuilder.add(index, type, ids);
        return  multiGetRequestBuilder.get();
    }

    /**
     * 多索引 多文档查询
     * @param list
     * @return
     * @throws UnknownHostException
     */
    public static MultiGetResponse multiGet(List<Map<String, Object>> list) throws UnknownHostException {
        Client client = ClientBuilder.build();
        MultiGetRequestBuilder multiGetRequestBuilder = client.prepareMultiGet();
        for(Map<String, Object> map : list){
            String indexName = (String) map.get(Params4Search.INDEX_NAME);
            String typeName = (String) map.get(Params4Search.TYPE_NAME);
            String [] StringArray = (String []) map.get(Params4Search.DOC_IDS);
            multiGetRequestBuilder.add(indexName,typeName,StringArray);
        }
        return  multiGetRequestBuilder.get();
    }

}
