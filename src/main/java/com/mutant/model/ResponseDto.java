package com.mutant.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@Builder
@Data
public class ResponseDto {

	@Schema(description = "Response status")
	private String status;

	@Schema(description = "Errors found through validations")
	private String errors;

	@Schema(description = "Datail found through validations")
	private String details;

	@Schema(description = "Object with de response information")
	private Object objects;

}
