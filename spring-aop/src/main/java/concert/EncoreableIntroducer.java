package concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/5/31 11:44
 */
@Aspect
public class EncoreableIntroducer {


    @DeclareParents(value = "concert.Performance+",defaultImpl = EncoreableImpl.class)
    public static Encoreable encoreable;
}
