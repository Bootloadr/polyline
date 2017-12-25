package com.hypertrack.service;

/**
 * @author abhinav
 * @date 24/12/17
 */

public interface ApiService<I,O> {
    public O callApi(I i);
}
