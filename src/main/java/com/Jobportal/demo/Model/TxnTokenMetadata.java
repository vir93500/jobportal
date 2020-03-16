package com.Jobportal.demo.Model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@JsonPropertyOrder(alphabetic = true)
public class TxnTokenMetadata {
    private String clientId;
    private String username;
}
