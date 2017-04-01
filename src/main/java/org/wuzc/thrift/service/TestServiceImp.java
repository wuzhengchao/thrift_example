package org.wuzc.thrift.service;

import org.wuzc.thrift.example.RequestInfo;
import org.wuzc.thrift.example.ResultInfo;
import org.wuzc.thrift.example.TestService;
import org.wuzc.thrift.example.UserInfo;
import org.apache.thrift.*;

/**
 * Created by wuzhengchao on 17-3-31.
 */
public class TestServiceImp implements TestService.Iface {

    public void ping(){
        System.out.println("receive a ping, sleep 5s first");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){

        }
        System.out.println("wake up, return ping");
    }

    public int add(int num1, int num2) throws TException {
        int sum = num1 + num2;
        System.out.println("receive a num request: " + num1 + " + " + num2 + " = " + sum);
        return sum;
    }

    public void zip() throws TException {
        System.out.println("receive a zip request. It's a oneway method! Sleep 5s first");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("wake up, return zip");


    }

    public ResultInfo getInfo(RequestInfo requestInfo) throws TException {
        System.out.println("Receive a getInfo request. ReqeustInfo: " + requestInfo.toString());

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(0);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("Jun Leibos");
        userInfo.setUserLocation("Bay Area, Beijing");
        userInfo.setAge(50);

        resultInfo.setUserInfo(userInfo);

        return resultInfo;
    }
}
