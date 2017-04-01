package org.wuzc.thrift.service;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.wuzc.thrift.example.TestService;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * Created by wuzhengchao on 17-4-1.
 */
public class Server {

    public static void main(String[] args) {
        try {
            TestServiceImp testServiceImp = new TestServiceImp();
            final TestService.Processor processor = new TestService.Processor(testServiceImp);

            Runnable simple = new Runnable() {
                public void run() {
                    simple(processor);
                }
            };

            new Thread(simple).start();

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void simple(TestService.Processor processor){
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(processor, serverTransport);

            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
