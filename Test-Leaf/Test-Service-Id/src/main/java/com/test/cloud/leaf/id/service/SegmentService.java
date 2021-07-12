package com.test.cloud.leaf.id.service;


import com.test.cloud.leaf.id.Constants;
import com.test.cloud.leaf.id.IDGen;
import com.test.cloud.leaf.id.IDGenService;
import com.test.cloud.leaf.id.common.PropertyFactory;
import com.test.cloud.leaf.id.common.Result;
import com.test.cloud.leaf.id.common.ZeroIDGen;
import com.test.cloud.leaf.id.exception.InitException;
import com.test.cloud.leaf.id.segment.SegmentIDGenImpl;
import com.test.cloud.leaf.id.segment.dao.IDAllocDao;
import com.test.cloud.leaf.id.segment.dao.impl.IDAllocDaoImpl;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



import java.sql.SQLException;
import java.util.Properties;

@Service("segmentService")
//@DubboService
public class SegmentService implements IDGenService {
    private Logger logger = LoggerFactory.getLogger(SegmentService.class);

    private IDGen idGen;

    private HikariDataSource dataSource ;

    public SegmentService() throws SQLException, InitException {
        Properties properties = PropertyFactory.getProperties();
        boolean flag = Boolean.parseBoolean(properties.getProperty(Constants.LEAF_SEGMENT_ENABLE, "true"));
        if (flag) {
            // Config dataSource
            dataSource = new HikariDataSource();
            dataSource.setJdbcUrl(properties.getProperty(Constants.LEAF_JDBC_URL));
            dataSource.setUsername(properties.getProperty(Constants.LEAF_JDBC_USERNAME));
            dataSource.setPassword(properties.getProperty(Constants.LEAF_JDBC_PASSWORD));

            // Config Dao
            IDAllocDao dao = new IDAllocDaoImpl(dataSource);

            // Config ID Gen
            idGen = new SegmentIDGenImpl();
            ((SegmentIDGenImpl) idGen).setDao(dao);
            if (idGen.init()) {
                logger.info("Segment Service Init Successfully");
            } else {
                throw new InitException("Segment Service Init Fail");
            }
        } else {
            idGen = new ZeroIDGen();
            logger.info("Zero ID Gen Service Init Successfully");
        }
    }

    public Result getId(String key) {
        return idGen.get(key);
    }

    public SegmentIDGenImpl getIdGen() {
        if (idGen instanceof SegmentIDGenImpl) {
            return (SegmentIDGenImpl) idGen;
        }
        return null;
    }
}
