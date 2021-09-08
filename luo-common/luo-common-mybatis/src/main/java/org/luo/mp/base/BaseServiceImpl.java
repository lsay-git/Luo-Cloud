package org.luo.mp.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.validation.annotation.Validated;

/**
 * @Date 16:13 2021/4/26
 * @Description {
 *   mybatis-plus BaseServiceImpl
 * }
 * @Author lsay
 **/
@Validated
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {
}
