package com.sofisticat.stockmanagerbackend.model.market;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Market {

    @JsonProperty
    String id;

    @JsonProperty
    String[] currentWorkers;

    @JsonProperty
    boolean isOnline;

    @JsonProperty
    MarketDetail details;

}
