package com.kjw.shop.common.auth;

import com.kjw.shop.common.exception.CustomException;
import com.kjw.shop.common.exception.HttpErrorType;
import com.kjw.shop.config.jwt.JwtTokenProvider;
import com.kjw.shop.member.model.Member;
import com.kjw.shop.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jinwook.kim
 * @since 2022/03/17
 */
@Aspect
@Component
@RequiredArgsConstructor
public class CheckRoleAop {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider tokenProvider;

    @Pointcut("execution(* com.kjw.shop..*.*(..))")
    private void cut(){}

    @Before("cut() && @annotation(auth)")
    public void before(JoinPoint joinPoint,CheckRole auth) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String header = request.getHeader("X-AUTH-TOKEN");
        Member member = memberRepository.findById(tokenProvider.getUserPk(header))
                .orElseThrow(() -> new IllegalArgumentException("error"));

        String checkRole = auth.auth().getValue();
        String memberRole = member.getRoles().get(0).getName().getValue();

        if (!checkRole.equals(memberRole)) {
            throw new CustomException(HttpErrorType.PERMISSION_DENY);
        }
    }
}
