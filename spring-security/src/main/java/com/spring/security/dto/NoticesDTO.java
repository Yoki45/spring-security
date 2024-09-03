package com.spring.security.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
@Schema(name = "Notices", description = "Holds bank notice details")
public class NoticesDTO {
    @Schema(description = "Unique Identifier of the notice")
    private long noticeId;

    @Schema(description = "Summary or brief overview of the notice")
    private String noticeSummary;

    @Schema(description = "Detailed content of the notice")
    private String noticeDetails;

    @Schema(description = "Start date when the notice becomes effective")
    private Date noticeBegDt;

    @Schema(description = "End date when the notice expires or becomes ineffective")
    private Date noticeEndDt;

    @JsonIgnore
    @Schema(description = "Date when the notice record was created", hidden = true)
    private Date createDt;

    @JsonIgnore
    @Schema(description = "Date when the notice record was last updated", hidden = true)
    private Date updateDt;
}
