//package com.example.backdemo.demo;
//
//import com.alibaba.fastjson.JSON;
//import org.kie.api.KieServices;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//
///**
// * sample.drl
// */
//public class DroolsTest {
//
//    public static final void main(String[] args) {
//        try {
//            // load up the knowledge base
//            KieServices ks = KieServices.Factory.get();
//            KieContainer kContainer = ks.getKieClasspathContainer();
//            KieSession kSession = kContainer.newKieSession("ksession-rules");
////            KieSession kSession = kContainer.newKieSession();
//
//            // go !
//            Message message = new Message();
//            message.setMessage("Hello World");
//            message.setStatus(Message.HELLO);
//
//            kSession.insert(message);
//            int i = kSession.fireAllRules();
//            System.out.println("执行了"+i+"条规则");
//            System.out.println(JSON.toJSONString(message));
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }
//    }
//
//}
