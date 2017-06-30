package orders.db.block;

import orders.bean.Block;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 色块 数据层接口实现
 *
 * @author wangjieyao
 * @Date 2017/6/13 11:21
 */
public class BlockRepositoryImpl implements BlockRepositoryCustom {

    @Resource
    @Qualifier("projectTemplate")
    private MongoTemplate mongoTemplate;

    @Override
    public Page<Block> listBlock(String name, Integer width, Integer height, Pageable pageable) {
        Query query = new Query();
        if(!StringUtils.isEmpty(name)){
            query.addCriteria(Criteria.where("name").regex(name));
        }
        if(!StringUtils.isEmpty(width)){
            query.addCriteria(Criteria.where("width").is(width));
        }
        if(!StringUtils.isEmpty(height)){
            query.addCriteria(Criteria.where("height").is(height));
        }
        Long totalCount =  mongoTemplate.count(query, Block.class);
        query.skip(pageable.getPageNumber() * pageable.getPageSize());
        query.limit(pageable.getPageSize());
        query.with(pageable.getSort());
        Page<Block> page = new PageImpl<Block>(mongoTemplate.find(query, Block.class), pageable,totalCount);
        return page;
    }
}
