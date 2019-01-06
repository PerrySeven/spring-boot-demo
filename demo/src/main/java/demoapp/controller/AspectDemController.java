package demoapp.controller;

import demoapp.common.MyAnnotation;
import demoapp.entity.model.ProjectInfo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/demo")
@Validated
public class AspectDemController {

    @GetMapping("/getData1")
    public String getData()
    {
        return  "getData1";
    }

    @MyAnnotation
    @GetMapping("/getData2")
    public String getData(String id)
    {
        return "getData2";
    }

    @PostMapping("/setData")
    public String setData(@Valid ProjectInfo  projectInfo, BindingResult result)
    {
        ProjectInfo pro = projectInfo;
//        if (result.hasErrors())
//        {
//            for (ObjectError er:result.getAllErrors())
//            {
//                System.out.println(er.getDefaultMessage());
//            }
//        }

        return  "project " + projectInfo.getProjectCode();
    }

    @RequestMapping("/setData1")
    public String setData1 (@Valid @RequestBody ProjectInfo  projectInfo)throws Exception
    {
        return  "project " + projectInfo.getProjectCode();
    }
}
