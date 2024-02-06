package org.example.Miko.Assignment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssemblyService {

    @Autowired
    RedisService redisService;

    public String operate(String statement) {
        String val = "Value moved";
        //Extract command
        String[] parts = statement.split("[,\\s]+");
        for(String part : parts)
            System.out.println(part  + " ");
        switch (parts[0]) {
            case "MV" -> redisService.setValue(parts[1], parts[2].substring(1));
            case "SHOW" -> {
                val = redisService.getValue(parts[1]);
            }
            case "ADD" -> {
                val = redisService.updateValue(parts[1], parts[2]);
            }
            case "DELETE" ->{
                val = redisService.deleteKey(parts[1]);
            }
            default -> {
                return "Invalid Command";
            }
        }

        return  val;
    }
}
