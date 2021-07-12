package com.test.cloud.leaf.id;


import com.test.cloud.leaf.id.common.Result;

public interface IDGen {
    Result get(String key);
    boolean init();
}
