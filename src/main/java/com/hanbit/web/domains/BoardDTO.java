package com.hanbit.web.domains;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
public class BoardDTO {
	@Getter @Setter private int artSeq;
	@Getter @Setter private String category;
	@Getter @Setter private String title;
	@Getter @Setter private String regDate;
	@Getter @Setter private String content;
	@Getter @Setter private String id;
	@Getter @Setter private String pw;
	@Getter @Setter private String name;
	@Getter @Setter private String writeDate;
	@Getter @Setter private String gender;
	@Getter @Setter private String ssn;
	@Getter @Setter private String profileImg;
	@Getter @Setter private String email;
	@Getter @Setter private String phone;
	@Getter @Setter private String role;
}
