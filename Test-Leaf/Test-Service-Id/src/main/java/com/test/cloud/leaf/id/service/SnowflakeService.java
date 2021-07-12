package com.test.cloud.leaf.id.service;


import com.test.cloud.leaf.id.Constants;
import com.test.cloud.leaf.id.IDGen;
import com.test.cloud.leaf.id.IDGenService;
import com.test.cloud.leaf.id.common.PropertyFactory;
import com.test.cloud.leaf.id.common.Result;
import com.test.cloud.leaf.id.common.ZeroIDGen;
import com.test.cloud.leaf.id.exception.InitException;
import com.test.cloud.leaf.id.snowflake.SnowflakeIDGenImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service("snowflakeService")
@DubboService
public class SnowflakeService implements IDGenService {
    private Logger logger = LoggerFactory.getLogger(SnowflakeService.class);

    private IDGen idGen;

    public SnowflakeService() throws InitException {
        Properties properties = PropertyFactory.getProperties();
        boolean flag = Boolean.parseBoolean(properties.getProperty(Constants.LEAF_SNOWFLAKE_ENABLE, "true"));
        if (flag) {
            String zkAddress = properties.getProperty(Constants.LEAF_SNOWFLAKE_ZK_ADDRESS);
            int port = Integer.parseInt(properties.getProperty(Constants.LEAF_SNOWFLAKE_PORT));
            idGen = new SnowflakeIDGenImpl(zkAddress, port);
            if(idGen.init()) {
                logger.info("Snowflake Service Init Successfully");
            } else {
                throw new InitException("Snowflake Service Init Fail");
            }
        } else {
            idGen = new ZeroIDGen();
            logger.info("Zero ID Gen Service Init Successfully");
        }
    }


    public Result getId(String key) {
        Result result = idGen.get(key);
        return result;
    }

    @Override
    public SnowflakeIDGenImpl getIdGen() {
        if (idGen instanceof SnowflakeIDGenImpl) {
            return (SnowflakeIDGenImpl) idGen;
        }
        return null;
    }
}
