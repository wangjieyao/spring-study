package orders.db.project;

import orders.bean.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 项目数据操作
 *
 * @author wangjieyao
 * @Date 2017/6/12 15:18
 */
@Repository
public interface ProjectRepository extends MongoRepository<Project, String>,ProjectRepositoryCustom {

    @Query("{name: {$regex: ?0}}")
    public Page<Project> listProject(String name, Pageable page);
}
