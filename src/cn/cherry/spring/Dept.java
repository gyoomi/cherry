/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.spring;

import java.io.Serializable;

/**
 * Dept Bean
 *
 * @author Leon
 * @version 2018/4/20 10:45
 */
public class Dept implements Serializable {
    private String id;
    private String name;
    private String parentId;
    private String nodeNum;

    public Dept() {
    }

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getNodeNum() {
        return nodeNum;
    }

    public void setNodeNum(String nodeNum) {
        this.nodeNum = nodeNum;
    }
}
