package cn.ccsu.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import cn.ccsu.entity.Admin;

/**
 * @author Bill
 *
 */
@Repository
public interface AdminMapper {

	Admin selectAdm(@Param("acc") String acc, @Param("passwd") String passwd);

}
