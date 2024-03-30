package com.orange.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginCheckAspect {

    @Autowired
    private HttpSession httpSession;

    @Around("@annotation(com.orange.aop.LoginCheck)")
    public Object checkLogin(ProceedingJoinPoint joinPoint) throws Throwable {
        Object loggedInMember = httpSession.getAttribute("loggedInMember");
        if (loggedInMember == null) {
        	 return "redirect:/loginCheck";
        }
        return joinPoint.proceed();
    }
}