package Application.controller;


import Application.service.txtservice;
import Application.user.txtCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/txt")
public class txtcontroller {
    @Autowired
    private txtservice txtservice;
    private String page;


    @PostMapping("/txtcode")
    public List<txtCode> txtcode(@RequestBody txtCode code){

        String pages = code.getPages();
        this.page=pages;
        List<txtCode> findall = txtservice.findall(pages);
        return findall;


    }
    @PostMapping("/txtcode_s")
    public List<txtCode> txtcode_s(){


        if (this.page!=null) {
            int page1= Integer.parseInt(page);
            page1=page1+1;
            this.page= String.valueOf(page1);
            System.out.println(page);
            List<txtCode> findall = txtservice.findall((this.page));
            return findall;
        }else{
            return txtservice.findall("0");
        }
    }
    @PostMapping("/txtcode_w")
    public List<txtCode> txtcode_w(){


        if (this.page!=null) {
            int page1= Integer.parseInt(page);
            page1=page1-1;
            this.page= String.valueOf(page1);
            System.out.println(page);
            List<txtCode> findall = txtservice.findall((this.page));
            return findall;
        }else{
            return txtservice.findall("0");
        }
    }
    @PostMapping("/txtcode_m")
    public List<txtCode> txtcode_m(){


        if (this.page!=null) {
            int page1= Integer.parseInt(page);
            this.page= String.valueOf(page1);
            System.out.println(page);
            List<txtCode> findall = txtservice.findall((this.page));
            return findall;
        }else{
            return txtservice.findall("0");
        }
    }

}
