package Application.Service;

import Application.Mapper.Txtcodemapper;
import Application.user.txtCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Txtservice {
    @Autowired
    private Txtcodemapper txtcodemapper;
    public List<txtCode> findOne(String pages){
        txtcodemapper.pages(Integer.parseInt(pages));
        return txtcodemapper.FindOne(pages);
    }
    public List<txtCode> next(){
        int pages = Integer.parseInt(txtcodemapper.cache());
        pages=pages+1;
        txtcodemapper.pages(pages);
        return txtcodemapper.FindOne(String.valueOf(pages));
    }
    public List<txtCode> previous(){
        int pages = Integer.parseInt(txtcodemapper.cache());
        pages=pages-1;
        txtcodemapper.pages(pages);
        return txtcodemapper.FindOne(String.valueOf(pages));
    }
    public List<txtCode> cache(){
        int pages = Integer.parseInt(txtcodemapper.cache());
        txtcodemapper.pages(pages);
        return txtcodemapper.FindOne(String.valueOf(pages));
    }


}
