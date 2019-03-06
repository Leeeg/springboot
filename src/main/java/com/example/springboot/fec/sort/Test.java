package com.example.springboot.fec.sort;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @Create by lee
 * @emil JefferyLeeeg@gmail.com
 * @Date 19-3-2
 * @Time 下午5:18
 */
public class Test {


    static AtomicInteger atomicInteger = new AtomicInteger(-1);
    static AtomicBoolean receiveAble = new AtomicBoolean(true);
    static AtomicInteger count = new AtomicInteger(0);

    static final int CATCH_COUNT = 10;

    static Random random = new Random();

    static BlockingDeque<RTP> rtpDeque = new LinkedBlockingDeque<>();
    static List<RTP> catchList = new ArrayList<>();
    static BlockingDeque<RTP> trackDeque = new LinkedBlockingDeque<>();

    static CatchThread catchThread;

    public static void main(String[] args) {
        new ReceiveThread().start();

        catchThread = new CatchThread();
        catchThread.start();

        new TrackThread().start();
    }

    static class ReceiveThread extends Thread{
        @Override
        public void run() {
            while (receiveAble.get()) {
//                    RTP rtp = new RTP(atomicInteger.addAndGet(1), System.currentTimeMillis(), null, 0);
                RTP rtp = new RTP(random.nextInt(100), System.currentTimeMillis(), null, 0);
                boolean b = rtpDeque.offer(rtp);
                System.out.println("add : " + rtp.toString() + "    " + b);
                if (rtpDeque.size() >= 20){
                    catchThread.unPark();
                }
                if (count.addAndGet(1) == 100){
                    receiveAble.set(false);
                    System.out.println(" ReceiveThread : over");
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class CatchThread extends Thread{
        @Override
        public void run() {
            while (true) {
                if (rtpDeque.size() >= CATCH_COUNT) {
                    System.out.println(" rtpDequeSize : " + rtpDeque.size());
                    System.out.println("  --- sort begin --- " + System.currentTimeMillis());
                    for (int i = 0; i < CATCH_COUNT; i++) {
                        RTP rtp1 = rtpDeque.poll();
                        if (null != rtp1) {
                            catchList.add(rtp1);
                        }
                    }
                    Collections.sort(catchList);
                    System.out.println("  --- sort end --- " + System.currentTimeMillis());
                    trackDeque.addAll(catchList);
                    System.out.println("trackDequeSize : " + trackDeque.size());
                    catchList.clear();
                } else {
                    System.out.println(" CatchThread : park");
                    LockSupport.park();
                }
            }
        }

        public void unPark(){
            LockSupport.unpark(this);
        }
    }

    static class TrackThread extends Thread{
        @Override
        public void run() {
            while (true) {
                RTP rtp = trackDeque.poll();
                if (null != rtp) {
                    System.out.println(" trackRunable : " + rtp.toString() + "     " + trackDeque.size());
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
