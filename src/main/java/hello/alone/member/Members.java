package hello.alone.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Members {
    private Long id;
    private String name;
    private Grades grade;
}
