package com.example.backdemo.netty.c1;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

class BasicModel implements Runnable {
    public void run() {
        try {
            ServerSocket ss =
                    new ServerSocket(SystemConfig.SOCKET_SERVER_PORT);
            while (!Thread.interrupted()){
                new Thread(new Handler(ss.accept())).start();
            }
            //创建新线程来handle
            // or, single-threaded, or a thread pool
        } catch (IOException ex) { /* ... */ }
    }

    static class Handler implements Runnable {
        final Socket socket;
        Handler(Socket s) { socket = s; }
        public void run() {
            try {
                byte[] input = new byte[SystemConfig.INPUT_SIZE];
                socket.getInputStream().read(input);
                byte[] output = process(input);
                socket.getOutputStream().write(output);
            } catch (IOException ex) { /* ... */ }
        }
        private byte[] process(byte[] input) {
            byte[] output=null;
            /* ... */
            return output;
        }
    }

    static class Server
    {

        public static void testServer() throws IOException
        {

            // 1、获取Selector选择器
            Selector selector = Selector.open();

            // 2、获取通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 3.设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            // 4、绑定连接
            serverSocketChannel.bind(new InetSocketAddress(SystemConfig.SOCKET_SERVER_PORT));

            // 5、将通道注册到选择器上,并注册的操作为：“接收”操作
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            // 6、采用轮询的方式，查询获取“准备就绪”的注册过的操作
            while (selector.select() > 0)
            {
                // 7、获取当前选择器中所有注册的选择键（“已经准备就绪的操作”）
                Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
                while (selectedKeys.hasNext())
                {
                    // 8、获取“准备就绪”的时间
                    SelectionKey selectedKey = selectedKeys.next();

                    // 9、判断key是具体的什么事件
                    if (selectedKey.isAcceptable())
                    {
                        // 10、若接受的事件是“接收就绪” 操作,就获取客户端连接
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        // 11、切换为非阻塞模式
                        socketChannel.configureBlocking(false);
                        // 12、将该通道注册到selector选择器上
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                    else if (selectedKey.isReadable())
                    {
                        // 13、获取该选择器上的“读就绪”状态的通道
                        SocketChannel socketChannel = (SocketChannel) selectedKey.channel();

                        // 14、读取数据
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int length = 0;
                        while ((length = socketChannel.read(byteBuffer)) != -1)
                        {
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array(), 0, length));
                            byteBuffer.clear();
                        }
                        socketChannel.close();
                    }

                    // 15、移除选择键
                    selectedKeys.remove();
                }
            }

            // 7、关闭连接
            serverSocketChannel.close();
        }

        public static void main(String[] args) throws IOException
        {
            testServer();
        }
    }
}