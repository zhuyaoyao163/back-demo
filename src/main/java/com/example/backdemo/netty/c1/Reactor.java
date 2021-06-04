package com.example.backdemo.netty.c1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Runnable
{
    final Selector selector;
    final ServerSocketChannel serverSocket;

    Reactor(int port) throws IOException
    { //Reactor初始化
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        //非阻塞
        serverSocket.configureBlocking(false);

        //分步处理,第一步,接收accept事件
        SelectionKey sk =
                serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        //attach callback object, Acceptor
        sk.attach(new Acceptor());
    }

    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while (it.hasNext())
                {
                    //Reactor负责dispatch收到的事件
                    dispatch((SelectionKey) (it.next()));
                }
                selected.clear();
            }
        } catch (IOException ex)
        { /* ... */ }
    }

    void dispatch(SelectionKey k)
    {
        Runnable r = (Runnable) (k.attachment());
        //调用之前注册的callback对象
        if (r != null)
        {
            r.run();
        }
    }

    // inner class
    class Acceptor implements Runnable
    {
        public void run()
        {
            try
            {
                SocketChannel channel = serverSocket.accept();
                if (channel != null)
                    new Handler(selector, channel);
            } catch (IOException ex)
            { /* ... */ }
        }
    }

    public static void main(String[] args) {
        String s = "{\"name\":\"其它\",\"flag\":\"SBDoc\",\"data\":[{\"param\":[{\"before\":{\"mode\":0,\"code\":\"\"},\"after\":{\"mode\":0,\"code\":\"\"},\"name\":\"参数\",\"id\":\"c6cf55cb-09ec-4f7b-ac3b-7d5d6a24a1e4\",\"remark\":\"\",\"header\":[],\"queryParam\":[],\"bodyParam\":[{\"name\":\"versionNum\",\"type\":0,\"must\":1,\"remark\":\"版本号\"},{\"name\":\"type\",\"type\":0,\"must\":1,\"remark\":\"0-android  1-ios\"}],\"bodyInfo\":{\"type\":0,\"rawType\":0,\"rawTextRemark\":\"\",\"rawFileRemark\":\"\",\"rawText\":\"\"},\"outParam\":[{\"name\":\"title\",\"type\":0,\"remark\":\"\",\"must\":0,\"mock\":\"\"},{\"name\":\"loc\",\"type\":0,\"remark\":\"更新路径\",\"must\":1,\"mock\":\"\"},{\"name\":\"content\",\"type\":0,\"remark\":\"更新内容\",\"must\":1,\"mock\":\"\"},{\"name\":\"hasNew\",\"type\":0,\"remark\":\"是否最新:0-是 1-否\",\"must\":1,\"mock\":\"\"},{\"name\":\"isForced\",\"type\":0,\"remark\":\"0-非强制更新  1-强制更新\",\"must\":1,\"mock\":\"\"}],\"outInfo\":{\"type\":0,\"rawRemark\":\"\",\"rawMock\":\"\",\"jsonType\":0},\"restParam\":[]}],\"finish\":1,\"sort\":9,\"flag\":\"SBDoc\",\"name\":\"IF201 - 获取最新版本号\",\"url\":\"/customer/other/getCurV\",\"remark\":\"\",\"method\":\"POST\",\"createdAt\":\"2019-01-20 14:46:13\",\"updatedAt\":\"2019-10-21 21:11:08\",\"__v\":0},{\"param\":[{\"before\":{\"mode\":0,\"code\":\"\"},\"after\":{\"mode\":0,\"code\":\"\"},\"name\":\"参数\",\"id\":\"f276f594-bca0-472e-a6a3-e95a48b40e59\",\"remark\":\"\",\"header\":[{\"name\":\"同IF801 - 牌价查询接口\",\"value\":\"\",\"remark\":\"\"}],\"queryParam\":[],\"bodyParam\":[{\"name\":\"type\",\"type\":0,\"must\":1,\"remark\":\"类别：1. Suggestion 2. Question 3. Complaint 4. Other\"},{\"name\":\"message\",\"type\":0,\"must\":1,\"remark\":\"具体内容\"}],\"bodyInfo\":{\"type\":0,\"rawType\":0,\"rawTextRemark\":\"\",\"rawFileRemark\":\"\",\"rawText\":\"\"},\"outParam\":[{\"name\":\"retCode\",\"type\":0,\"remark\":\"处理状态(0-成功 其它是错误编码)\",\"must\":1,\"mock\":\"\"},{\"name\":\"message\",\"type\":0,\"remark\":\"错误信息，成功时没有\",\"must\":0,\"mock\":\"\"}],\"outInfo\":{\"type\":0,\"rawRemark\":\"\",\"rawMock\":\"\",\"jsonType\":0},\"restParam\":[]}],\"finish\":0,\"sort\":2,\"flag\":\"SBDoc\",\"name\":\"IF702 - 反馈意见\",\"url\":\"/customer/appeal/save\",\"remark\":\"\",\"method\":\"POST\",\"createdAt\":\"2019-01-20 14:45:04\",\"updatedAt\":\"2019-10-29 16:34:34\",\"__v\":0},{\"param\":[{\"before\":{\"mode\":0,\"code\":\"\"},\"after\":{\"mode\":0,\"code\":\"\"},\"name\":\"参数\",\"id\":\"f276f594-bca0-472e-a6a3-e95a48b40e59\",\"remark\":\"\",\"header\":[{\"name\":\"同IF801 - 牌价查询接口\",\"value\":\"\",\"remark\":\"\"}],\"queryParam\":[],\"bodyParam\":[{\"name\":\"message\",\"type\":0,\"must\":1,\"remark\":\"问题\"}],\"bodyInfo\":{\"type\":0,\"rawType\":0,\"rawTextRemark\":\"\",\"rawFileRemark\":\"\",\"rawText\":\"\"},\"outParam\":[{\"name\":\"retCode\",\"type\":0,\"remark\":\"处理状态(0-成功 其它是错误编码)\",\"must\":1,\"mock\":\"\"},{\"name\":\"message\",\"type\":0,\"remark\":\"错误信息，成功时没有\",\"must\":0,\"mock\":\"\"}],\"outInfo\":{\"type\":0,\"rawRemark\":\"\",\"rawMock\":\"\",\"jsonType\":0},\"restParam\":[]}],\"finish\":0,\"sort\":3,\"flag\":\"SBDoc\",\"name\":\"IF703 - QA\",\"url\":\"/other/sendQA\",\"remark\":\"提问题\",\"method\":\"POST\",\"createdAt\":\"2019-01-20 14:45:04\",\"updatedAt\":\"2019-08-21 22:04:25\",\"__v\":0},{\"param\":[{\"before\":{\"mode\":0,\"code\":\"\"},\"after\":{\"mode\":0,\"code\":\"\"},\"name\":\"参数\",\"id\":\"f276f594-bca0-472e-a6a3-e95a48b40e59\",\"remark\":\"\",\"header\":[{\"name\":\"同IF801 - 牌价查询接口\",\"value\":\"\",\"remark\":\"\"}],\"queryParam\":[],\"bodyParam\":[{\"name\":\"message\",\"type\":0,\"must\":1,\"remark\":\"问题\"}],\"bodyInfo\":{\"type\":0,\"rawType\":0,\"rawTextRemark\":\"\",\"rawFileRemark\":\"\",\"rawText\":\"\"},\"outParam\":[{\"name\":\"retCode\",\"type\":0,\"remark\":\"处理状态(0-成功 其它是错误编码)\",\"must\":1,\"mock\":\"\"},{\"name\":\"message\",\"type\":0,\"remark\":\"错误信息，成功时没有\",\"must\":0,\"mock\":\"\"}],\"outInfo\":{\"type\":0,\"rawRemark\":\"\",\"rawMock\":\"\",\"jsonType\":0},\"restParam\":[]}],\"finish\":0,\"sort\":4,\"flag\":\"SBDoc\",\"name\":\"IF704 - 帮助汇款\",\"url\":\"/other/helpTrans\",\"remark\":\"要求帮助汇款\",\"method\":\"POST\",\"createdAt\":\"2019-01-20 14:45:04\",\"updatedAt\":\"2019-08-21 22:04:25\",\"__v\":0},{\"param\":[{\"before\":{\"mode\":0,\"code\":\"\"},\"after\":{\"mode\":0,\"code\":\"\"},\"name\":\"参数\",\"id\":\"f276f594-bca0-472e-a6a3-e95a48b40e59\",\"remark\":\"\",\"header\":[{\"name\":\"Content-Type\",\"value\":\"application/application/json\",\"remark\":\"\"},{\"name\":\"sessionId\",\"value\":\"用户登陆时，服务器给的sessionID\",\"remark\":\"\"},{\"name\":\"lan\",\"value\":\"语言类别\",\"remark\":\"cn-中文 en-英文\"},{\"name\":\"device\",\"value\":\"\",\"remark\":\"例：iPhone11,8；iPhone11,6\"},{\"name\":\"timestamp\",\"value\":\"当前时间戳(毫秒)\",\"remark\":\"\"}],\"queryParam\":[],\"bodyParam\":[{\"name\":\"buyCurrency\",\"type\":0,\"must\":1,\"remark\":\"买入币种\"},{\"name\":\"sellCurrency\",\"type\":0,\"must\":1,\"remark\":\"卖出币种\"}],\"bodyInfo\":{\"type\":0,\"rawType\":0,\"rawTextRemark\":\"\",\"rawFileRemark\":\"\",\"rawText\":\"\"},\"outParam\":[{\"name\":\"retCode\",\"type\":0,\"remark\":\"\",\"must\":1,\"mock\":\"\"},{\"name\":\"message\",\"type\":0,\"remark\":\"\",\"must\":1,\"mock\":\"\"},{\"name\":\"data\",\"type\":3,\"remark\":\"\",\"must\":1,\"mock\":\"\",\"data\":[{\"name\":null,\"type\":4,\"remark\":\"\",\"must\":1,\"mock\":\"\",\"data\":[{\"name\":\"sellCurrency\",\"type\":0,\"remark\":\"卖出币种\",\"must\":1,\"mock\":\"\"},{\"name\":\"buyCurrency\",\"type\":0,\"remark\":\"买入币种\",\"must\":1,\"mock\":\"\"},{\"name\":\"rate\",\"type\":0,\"remark\":\"汇率\",\"must\":1,\"mock\":\"\"},{\"name\":\"queryTime\",\"type\":0,\"remark\":\"查询时间\",\"must\":1,\"mock\":\"\"}]}]}],\"outInfo\":{\"type\":0,\"rawRemark\":\"\",\"rawMock\":\"\",\"jsonType\":0},\"restParam\":[]}],\"finish\":1,\"sort\":0,\"name\":\"IF705 - 汇率曲线查询\",\"url\":\"/rate/getRateHistory\",\"remark\":\"汇率曲线查询\",\"method\":\"POST\",\"createdAt\":\"2019-10-16 14:46:42\",\"updatedAt\":\"2019-10-21 16:54:54\",\"__v\":0}]}";
        System.out.println(s.getBytes(StandardCharsets.UTF_8).length);
    }
}