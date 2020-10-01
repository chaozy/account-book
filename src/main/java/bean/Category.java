package bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

/**
 * Correspond to table Category
 */
@Repository
@Getter @Setter
public class Category {
    private int id;
    private String name;

    private int recordNumber;


}
