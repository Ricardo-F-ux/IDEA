package com.fjq.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议的网络编程
 *
 * @author EnvyFL
 * @create 2021-04-23-10:06 上午
 * @class
 */
public class UDPTest {

    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();


        String str = "我是UDP方式发送的导弹";
        byte [] data = str.getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);

        socket.send(packet);

        socket.close();

    }


    @Test
    public void receiver() throws IOException{

        DatagramSocket socket = new DatagramSocket(9090);

        byte [] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
