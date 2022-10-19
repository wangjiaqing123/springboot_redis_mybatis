package Application.service;


import Application.mapper.txtcodemapper;
import Application.user.txtCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class txtservice {
    @Autowired
    private txtcodemapper txtcodemapper;


    public List<txtCode> findall(String pages){
        return txtcodemapper.FindALL(pages);
    }

}
