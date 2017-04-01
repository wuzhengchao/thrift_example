package org.wuzc.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.wuzc.thrift.example.RequestInfo;
import org.wuzc.thrift.example.ResultInfo;
import org.wuzc.thrift.example.TestService;

/**
 * Created by wuzhengchao on 17-4-1.
 */
public class TestClient {
    public static void main(String [] args) {
        try {
            TTransport transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);

            TestService.Client client = new TestService.Client(protocol);

            System.out.println("start call ping");
            client.ping();
            System.out.println("end call ping");

            int sum = client.add(3, 5);
            System.out.println("3 + 5 +" + sum);

            System.out.println("start call zip");
            client.zip();
            System.out.println("end call zip");

            RequestInfo requestInfo = new RequestInfo();
            requestInfo.setAge(8);
            ResultInfo resultInfo = client.getInfo(requestInfo);
            System.out.println(resultInfo.toString());

        } catch (TException ex) {
            ex.printStackTrace();
        }
    }
}
