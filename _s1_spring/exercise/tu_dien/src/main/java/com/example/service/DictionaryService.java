package com.example.service;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    private static Map<String,String> map=new HashMap<>();
    static {
        map.put("hello","xin chào");
        map.put("bye","tạm biệt");
    }
    @Override
    public String iDictionaryService(String english) {
        if (map.get(english)!=null){
            return map.get(english);
        }else {
            return "Not Found";
        }
    }
}
