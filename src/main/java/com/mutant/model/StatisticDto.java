package com.mutant.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StatisticDto {

	@Schema(description = "Amount mutants")
	double count_mutant_dan;

	@Schema(description = "Amount human")
	double count_human_dan;

	@Schema(description = "Comparation between mutants/humans")
	double ratio;

}
