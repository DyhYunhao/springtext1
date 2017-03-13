package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dyh on 17-3-11.
 */
@Controller
@RequestMapping("/")
public class control1 {
        //静态返回页面
        @RequestMapping("/he")
        public String sdf(ModelMap model) {
            model.addAttribute("name", "hello");
            return "index";
        }
    //URL传递参数
    @RequestMapping(value = "/page/{name}/{age}",method = RequestMethod.GET)
    public String get_name(ModelMap map, @PathVariable("name") String name, @PathVariable("age") int age){
        map.addAttribute("name",name);
        map.addAttribute("age",age);
        System.out.println(name+" "+age);
        return "name";
    }
    //URL输入参数
    @RequestMapping(value = "/result",method = RequestMethod.GET)
    public String result(ModelMap map, @RequestParam String name, @RequestParam("age") int age){
        map.addAttribute("name",name);
        map.addAttribute("age",age);
        return "result";
    }
    //表单
    @RequestMapping(value = "/adduser",method = RequestMethod.GET)
    public String addUser(ModelMap map){
        return "adduser";
    }

}
