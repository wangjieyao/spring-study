package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

  private SpitterRepository spitterRepository;

  @Autowired
  public SpitterController(SpitterRepository spitterRepository) {
    this.spitterRepository = spitterRepository;
  }
  
  @RequestMapping(value="/register", method=GET)
  public String showRegistrationForm(Model model) {
    model.addAttribute(new Spitter());
    return "registerForm";
  }
  
//  @RequestMapping(value="/register", method=POST)
//  public String processRegistration(
//      @Valid Spitter spitter,  //校验spitter输入
//      Errors errors) {
//    if (errors.hasErrors()) {  //校验错误则重新返回表单视图
//      return "registerForm";
//    }
//    //保存注册信息
//    spitterRepository.save(spitter);
//    //重定向到基本信息页
//    return "redirect:/spitter/" + spitter.getUsername();
//  }

  @RequestMapping(value="/register", method=POST)
  public String processRegistration(
          @Valid SpitterForm spitterForm,  //校验spitter输入
          Errors errors) throws IOException {
    if (errors.hasErrors()) {  //校验错误则重新返回表单视图
      return "registerForm";
    }
    Spitter spitter  = spitterForm.toSpitter();
    //保存注册信息
    spitterRepository.save(spitter);

    MultipartFile multipartFile = spitterForm.getProfilePicture();
    //将上传的文件写入到文件系统中
    multipartFile.transferTo(new File("E:/code/IdeaProjects/git/spring-study/spring-spittr2/data/" + multipartFile.getOriginalFilename()));
    //重定向到基本信息页
//    return "redirect:/spitter/" + spitter.getUsername();
    return "redirect:/spitter/" + spitter.getUsername();
  }
  
  @RequestMapping(value="/{username}", method=GET)
  public String showSpitterProfile(@PathVariable String username, Model model) {
    Spitter spitter = spitterRepository.findByUsername(username);
    model.addAttribute(spitter);
    return "profile";
  }

//  @RequestMapping(value="/register", method=POST)
//  public String processRegistration(@Valid Spitter spitter, Model model) {
//    //保存注册信息
//    spitterRepository.save(spitter);
//    model.addAttribute("userName",spitter.getUsername());
//    //重定向到基本信息页
//    return "redirect:/spitter/{userName}";
//  }

  
}
