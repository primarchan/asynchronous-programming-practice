package com.primarchan.async.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {

    /**
     * @Async 어노테이션을 사용하기 위해서는 접근제한자를 public 으로 선언
     */

    @Async("defaultTaskExecutor ")
    public void sendMail() {
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }

    @Async("messagingTaskExecutor")
    public void sendMailWithCustomThreadPool() {
        System.out.println("[messagingTaskExecutor] :: " + Thread.currentThread().getName());
    }
}
