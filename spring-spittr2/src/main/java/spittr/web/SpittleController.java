package spittr.web;

import java.util.Date;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittr.Spitter;
import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

  private static final String MAX_LONG_AS_STRING = "9223372036854775807";
  
  private SpittleRepository spittleRepository;

  //注入SpittleRepository
  @Autowired
  public SpittleController(SpittleRepository spittleRepository) {
    this.spittleRepository = spittleRepository;
  }

  @RequestMapping(method=RequestMethod.GET)
  public List<Spittle> spittles(
      @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
      @RequestParam(value="count", defaultValue="20") int count) {
    return spittleRepository.findSpittles(max, count);
  }

  @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
  public String spittle(
      @PathVariable("spittleId") long spittleId,
      Model model) {
    Spittle  spittle = null;
    try {
      spittle = spittleRepository.findOne(spittleId);
    } catch (Exception e) {
      throw new SpittleNotFoundException();
    }
    if (spittle ==null){
      throw new SpittleNotFoundException();
    }
    model.addAttribute(spittle);
    return "spittle";
  }

//  @RequestMapping(method=RequestMethod.POST)
//  public String saveSpittle(SpittleForm form, Model model) {
//    try {
//      spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
//              form.getLongitude(), form.getLatitude()));
//      return "redirect:/spittles";
//    } catch (DuplicateSpittleException e) {
//      return "error/duplicate";
//    }
//  }

  @RequestMapping(method=RequestMethod.POST)
  public String saveSpittle(SpittleForm form, Model model) throws Exception {
    spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
            form.getLongitude(), form.getLatitude()));
    return "redirect:/spittles";
  }

  @ExceptionHandler(DuplicateSpittleException.class)
  public String handleNotFound() {
    return "error/duplicate";
  }

  @RequestMapping("redireceFrom")
  public String redireceFrom(long spittleId, RedirectAttributes model){
    Spittle spittle = spittleRepository.findOne(spittleId);
    model.addFlashAttribute("spittle",spittle);
    return "redirect:/spittles/redireceTo";
  }

  @RequestMapping("redireceTo")
  public String redireceTo(Model model){
    if (model != null && model.containsAttribute("spittle")){
      System.out.println("model contain spittle");
    }
    return "redirect:/spittles";
  }

}
