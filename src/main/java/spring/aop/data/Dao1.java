package spring.aop.data;

import org.springframework.stereotype.Repository;
import spring.aop.aspect.TrackTime;

@Repository
public class Dao1 {

    @TrackTime
    public String retrieveSomething(){
        return "Dao1";
    }
}
