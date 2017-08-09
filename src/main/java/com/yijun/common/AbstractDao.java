package com.yijun.common;

import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by kinglas on 2017/7/28.
 */
public interface AbstractDao<T> {
    void insert(T t) throws Exception;
    void update(T t) throws  Exception;
    void delete(@Param("key") String ukfield,@Param("value") Object value) throws Exception;
    T select(@Param("key") String ukfield,@Param("value") Object value) throws Exception;
    T selectAll() throws Exception;
    boolean exists(@Param("key") String ukfield,@Param("value") Object value) throws Exception;
    List<T> selectLike(String key)throws Exception;
}
