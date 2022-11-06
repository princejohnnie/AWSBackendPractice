package com.princejohnnie.awspractice.request;

import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public class AMIRequest {

    private List<String> regions;

    public AMIRequest() {


    }

    public AMIRequest(List<String> regions) {
        this.regions = regions;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }
}
