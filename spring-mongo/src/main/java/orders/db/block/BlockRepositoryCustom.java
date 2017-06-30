package orders.db.block;

import orders.bean.Block;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 色块 数据层接口抽象
 *
 * @author wangjieyao
 * @Date 2017/6/13 11:23
 */
public interface BlockRepositoryCustom {

    /**
     * 分页查询色块列表
     * @param name
     * @param width
     * @param height
     * @param pageable
     * @return
     */
    public Page<Block> listBlock(String name, Integer width, Integer height, Pageable pageable);
}
