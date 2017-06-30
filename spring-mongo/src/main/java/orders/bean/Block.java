package orders.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 色块实体
 *
 * @author wangjieyao
 * @Date 2017/6/13 11:09
 */
@Document(collection="block")
public class Block {

    @Id
    private String id;

    /**
     * 色块名称
     */
    private String title;

    /**
     * 色块宽度
     */
    private int width;

    /**
     * 色块高度
     */
    private int height;

    /**
     * 色块尺寸类型
     * width >= height => W
     * width < height  => H
     */
    private String blockSizeType;

    /**
     * 项目id
     */
    private List<String> projectIds;

    /**
     * 项目名称，保存时不保存该字段
     */
    private List<String> projectNames;

    /**
     * 色块描述
     */
    private String description;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 操作者
     */
    private String user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBlockSizeType() {
        return blockSizeType;
    }

    public void setBlockSizeType(String blockSizeType) {
        this.blockSizeType = blockSizeType;
    }

    public List<String> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<String> projectIds) {
        this.projectIds = projectIds;
    }

    public List<String> getProjectNames() {
        return projectNames;
    }

    public void setProjectNames(List<String> projectNames) {
        this.projectNames = projectNames;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
