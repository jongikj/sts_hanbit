package com.hanbit.web.domains;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
public class Command {
	@Getter @Setter private String keyField, keyword;
	@Getter @Setter private int start, end;
}
