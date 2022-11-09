package com.primarchan.async.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AsyncService {

    private final EmailService emailService;

    /**
     * @apiNote Case 1. Spring Bean 주입
     */
    public void asyncCall_1() {
        System.out.println("[asyncCall_1] :: " + Thread.currentThread().getName());
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
        /*
        - Spring Container 에 등록된 Bean 사용 시
        - 해당 Bean 을 Spring Framework 에 의해 Proxy 객체로 Wrapping 되어 return 됨
        - 비동기로 동작할 수 있도록 Sub Thread 에게 위임
        - emailService.sendEmail()
         */
    }

    /**
     * @apiNote Case 2. 인스턴스 생성 -> 인스턴스의 메서드 사용
     */
    public void asyncCall_2() {
        System.out.println("[asyncCall_2] :: " + Thread.currentThread().getName());
        EmailService emailService = new EmailService();
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    /**
     * @apiNote Case 3. 내부 메서드 사용
     */
    public void asyncCall_3() {
        System.out.println("[asyncCall_3] :: " + Thread.currentThread().getName());
        sendMail();
    }

    @Async
    public void sendMail() {
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }

}
