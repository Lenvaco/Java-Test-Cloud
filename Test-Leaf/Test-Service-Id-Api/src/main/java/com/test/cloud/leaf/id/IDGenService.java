package com.test.cloud.leaf.id;


import com.test.cloud.leaf.id.common.Result;

public interface IDGenService {
    Result getId(String key);

    IDGen getIdGen();
}
