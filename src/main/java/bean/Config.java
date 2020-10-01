package bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Correspond to table Config
 */
@Component
@Getter
@Setter
public class Config {
    private int id;
    private String key;
    private String value;


}
