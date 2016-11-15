package controller;

import entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ValueConstants;
import service.ChallengService;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
@Controller
public class ActivityController {
    @Autowired
    private ChallengService challengService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<Activity> list(){

        return challengService.getAllActivity();
    }

    @RequestMapping(value = "/tolist")
    public String toList(){

        return "list";
    }

    @RequestMapping(value = "/add")
    public String add(Activity activity){
        challengService.start(activity);
        return "list";
    }
}
