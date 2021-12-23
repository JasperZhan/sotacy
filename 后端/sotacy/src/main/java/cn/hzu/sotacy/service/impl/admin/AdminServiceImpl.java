package cn.hzu.sotacy.service.impl.admin;

import cn.hzu.sotacy.model.admin.Admin;
import cn.hzu.sotacy.dao.admin.AdminDao;
import cn.hzu.sotacy.service.admin.AdminService;
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
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {

}
