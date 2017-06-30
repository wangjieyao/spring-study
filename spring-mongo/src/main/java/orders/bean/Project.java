package orders.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 项目实体
 *
 * @author wangjieyao
 * @Date 2017/6/12 15:02
 */
@Document(collection = "project")
public class Project {

    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 项目名称 e.g 应用商店
     */
    private String name;

    /**
     * 项目唯一表标识 e.g appstore
     */
    private String key;

    /**
     * 项目描述
     */
    private String description;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 创建时间
     */
    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
