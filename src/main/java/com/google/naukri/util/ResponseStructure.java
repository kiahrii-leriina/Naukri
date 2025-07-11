package com.google.naukri.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponseStructure<T> {
	private int status;
	private String message;
	private T body;
}
