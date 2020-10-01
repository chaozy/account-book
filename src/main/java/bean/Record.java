package bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
public class Record {
    private int id;
    private int spend;
    private int cid;
    private String payment;
    private Date date;
    private String comment;


}
