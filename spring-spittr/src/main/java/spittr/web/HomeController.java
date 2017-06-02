package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/5/31 17:44
 */
@Controller
public class HomeController {

    //将控制器映射到"/",处理get请求
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "home";  //视图名为home
    }
}
