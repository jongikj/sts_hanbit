package com.hanbit.web.domains;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
public class ExamDTO {
	@Getter @Setter private int examSeq;
	@Getter @Setter private int subjSeq;
	@Getter @Setter private int score;
	@Getter @Setter private String term;
	@Getter @Setter private String id;
}
