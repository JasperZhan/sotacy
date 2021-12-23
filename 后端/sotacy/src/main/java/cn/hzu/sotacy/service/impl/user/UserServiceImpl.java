package cn.hzu.sotacy.service.impl.user;

import cn.hzu.sotacy.model.user.User;
import cn.hzu.sotacy.dao.user.UserDao;
import cn.hzu.sotacy.service.user.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2021-12-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
