package spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/6/6 16:54
 */
//将异常映射为特定的状态码404
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Incorrect result size: expected 1, actual 0")
public class SpittleNotFoundException extends RuntimeException{
}
