package com.tracy.gd.service;

import com.tracy.gd.domain.Computer;
import org.springframework.stereotype.Service;

/**
 * Created by tracy on 2017/11/9.
 */

public interface IComputerService {

    Computer selectByPrimaryKey(Integer cptId);

}
