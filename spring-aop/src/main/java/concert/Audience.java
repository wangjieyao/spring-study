package concert;

import org.aspectj.lang.annotation.*;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/5/27 13:53
 */
//标注这个一个切面，这里用到了三种类型的通知
@Aspect
public class Audience {

    @Pointcut("execution(* concert.Performance.perform(..))")
    public void performance(){
    }
    //表演之前手机关闭静音
    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("Silence cell phones");
    }

    //表演之前坐好
    @Before("performance()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    //表演之后鼓掌
    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP ...");
    }

    //表演失败后返场
    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }
}
