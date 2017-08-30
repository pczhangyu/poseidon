package com.poseidon.search.builders;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class ClientBuilder {

    private static Client client = null;

    private ClientBuilder() {
        // do nothing
    }

    /**
     *
     * @return
     * @throws UnknownHostException
     */
    public static synchronized Client build() throws UnknownHostException {
        if(client == null){
//            // 配置集群 正式
//            Settings settings = Settings.settingsBuilder().put("cluster.name", "cluster_jz").build();
//            client = TransportClient.builder().settings(settings).build()
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.51.48.88"), 9300))
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.44.158.165"), 9300))
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.44.136.33"), 9300));

            // 配置集群 测试
            Settings settings = Settings.settingsBuilder().put("cluster.name", "cluster_jz").build();
            client = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.128.139"), 9300));
        }
        return client;
    }

//    public static void main(String[] args){
//        try {
//            Client client = ClientBuilder.build();
//            System.out.println("client >>>>>>>>>>>>>>>> " + client);
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//    }
}
