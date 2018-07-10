/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.q_netty_marshalling;

import java.io.Serializable;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/7/10 14:57
 */
public class Request implements Serializable {

    private String url;

    public Request() {}

    public Request(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Request{" +
                "url='" + url + '\'' +
                '}';
    }
}
