package orders.db.block;

import orders.bean.Block;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * 色块数据层
 *
 * @author wangjieyao
 * @Date 2017/6/13 11:21
 */
public interface BlockRepository extends MongoRepository<Block, String>,BlockRepositoryCustom {

    /**
     * 根据项目id获取色块列表
     * @param projectIds
     * @return
     */
    @Query("{projectIds:{$in:?0}}")
    public List<Block> findBlocksByProjectId(List<String> projectIds);
}
