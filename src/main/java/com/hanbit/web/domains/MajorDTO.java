package com.hanbit.web.domains;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @date   :2016. 6. 16.
 * @author :장종익
 * @story  :
*/
@Component
@Data
public class MajorDTO {
	@Getter @Setter private String id;
	@Getter @Setter private String pw;
	@Getter @Setter private String name;
	@Getter @Setter private String regDate;
	@Getter @Setter private String gender;
	@Getter @Setter private String ssn;
	@Getter @Setter private String profileImg;
	@Getter @Setter private String email;
	@Getter @Setter private String phone;
	@Getter @Setter private String majorTitle;
	@Getter @Setter private String role;
	@Getter @Setter private int majorSeq;
}	
