package orders.db.project;


import orders.bean.Project;

/**
 * 项目数据操作抽象
 *
 * @author wangjieyao
 * @Date 2017/6/12 15:19
 */
public interface ProjectRepositoryCustom {

    /**
     * 根据项目名称获取项目
     * @param name
     * @return
     */
    Project getProjectByName(String name);

    /**
     * 根据key获取项目
     * @param key
     * @return
     */
    Project getProjectByKey(String key);

}
